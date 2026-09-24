package com.example.session2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4_GenericJsonClient {

    private static final HttpClient CLIENT =
            HttpClient.newHttpClient();

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper();

    public static <T> T fetchAndParseJson(
            String url,
            Class<T> valueType) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "API returned HTTP status: "
                            + response.statusCode()
            );
        }

        return OBJECT_MAPPER.readValue(
                response.body(),
                valueType
        );
    }

    public static void main(String[] args) {

        String url =
                "https://official-joke-api.appspot.com/random_joke";

        try {

            Joke joke = fetchAndParseJson(
                    url,
                    Joke.class
            );

            System.out.println("Setup: " + joke.setup());
            System.out.println("Punchline: " + joke.punchline());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public record Joke(
            int id,
            String type,
            String setup,
            String punchline) {
    }
}
