package com.moviebot.service;

import com.moviebot.exception.OpenAiApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

/**
 * ===== TASK 2, 3 & 4 =====
 *
 * Service responsible for calling the OpenAI Chat Completions API.
 *
 * Task 4 note: the HTTP POST call below was drafted with the help of
 * ChatGPT ("write Java code to send a POST request to the OpenAI chat
 * completions endpoint using Spring's WebClient") and then adapted to:
 *   - read the API key + model name from application.properties
 *   - throw a custom OpenAiApiException instead of letting raw exceptions
 *     leak out, so the controller (Task 3) can turn them into clean JSON
 *     error responses instead of a generic 500 stack trace.
 */
@Service
public class OpenAiService {

    private final WebClient webClient;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.model}")
    private String model;

    public OpenAiService(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Sends the user's question to OpenAI and returns the assistant's reply.
     *
     * @param question the user's movie-related question
     * @return the AI-generated answer text
     * @throws OpenAiApiException if the key is missing/invalid or OpenAI
     *                            returns a non-200 status code
     */
    public String getMovieAnswer(String question) {

        // ---- Task 3: check for a missing API key BEFORE calling OpenAI ----
        if (apiKey == null || apiKey.isBlank()) {
            throw new OpenAiApiException(
                    "OpenAI API key is missing. Set the OPENAI_API_KEY environment variable.",
                    HttpStatusCode.valueOf(401)
            );
        }

        // System prompt keeps the bot focused on movie recommendations/questions.
        Map<String, Object> requestBody = Map.of(
                "model", model,
                "messages", List.of(
                        Map.of(
                                "role", "system",
                                "content", "You are MovieBot, a knowledgeable and friendly assistant " +
                                        "that answers questions about movies, gives recommendations, " +
                                        "and shares fun film trivia."
                        ),
                        Map.of(
                                "role", "user",
                                "content", question
                        )
                ),
                "temperature", 0.7
        );

        try {
            // ---- Task 2 & 4: the actual HTTP POST call to OpenAI ----
            Map<String, Object> response = webClient.post()
                    .uri(apiUrl)
                    .header("Authorization", "Bearer " + apiKey)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            return extractAnswer(response);

        } catch (WebClientResponseException ex) {
            // ---- Task 3: handle non-200 codes from OpenAI (401, 429, 500, etc.) ----
            String reason = switch (ex.getStatusCode().value()) {
                case 401 -> "Invalid OpenAI API key.";
                case 429 -> "Rate limit exceeded or quota exhausted on OpenAI account.";
                case 400 -> "Bad request sent to OpenAI (check the request payload).";
                default -> "OpenAI API returned an error: " + ex.getStatusText();
            };
            throw new OpenAiApiException(reason, ex.getStatusCode());

        } catch (Exception ex) {
            // Catch-all for network errors, timeouts, etc.
            throw new OpenAiApiException(
                    "Failed to reach OpenAI API: " + ex.getMessage(),
                    HttpStatusCode.valueOf(502)
            );
        }
    }

    @SuppressWarnings("unchecked")
    private String extractAnswer(Map<String, Object> response) {
        if (response == null || !response.containsKey("choices")) {
            throw new OpenAiApiException("Unexpected response format from OpenAI.", HttpStatusCode.valueOf(502));
        }

        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        if (choices.isEmpty()) {
            throw new OpenAiApiException("OpenAI returned no answer choices.", HttpStatusCode.valueOf(502));
        }

        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
        return (String) message.get("content");
    }
}
