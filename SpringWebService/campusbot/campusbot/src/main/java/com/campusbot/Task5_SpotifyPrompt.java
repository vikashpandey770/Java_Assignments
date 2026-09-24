package com.campusbot;

// ===== TASK 5 =====
// Use ChatGPT/Copilot to help write a prompt template for a Spotify music
// recommendation bot in LangChain4J. The AI-assisted template + explanation
// of what improved is documented in TASK5_REFLECTION.md at the project root.
// This class shows the final, working version of that template.

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.HashMap;
import java.util.Map;

public class Task5_SpotifyPrompt {

    public static void main(String[] args) {

        // Final AI-assisted prompt template (see TASK5_REFLECTION.md for the
        // "before/after" story of how this was refined with ChatGPT).
        PromptTemplate template = PromptTemplate.from(
                "You are CampusBot, a Spotify-style music recommendation assistant.\n" +
                "User mood/genre request: \"{{request}}\"\n" +
                "User's favorite artist (optional context): \"{{favoriteArtist}}\"\n\n" +
                "Recommend exactly 5 songs that match this request.\n" +
                "For each song, respond in this exact format on one line:\n" +
                "Song Title - Artist Name (Genre) - one short reason it fits the mood\n\n" +
                "Only include real, existing songs. Do not repeat the same artist twice. " +
                "Keep the tone upbeat and playlist-curator-like."
        );

        Map<String, Object> variables = new HashMap<>();
        variables.put("request", "chill lo-fi songs to study to");
        variables.put("favoriteArtist", "Lauv");

        Prompt prompt = template.apply(variables);

        System.out.println("=======================================================");
        System.out.println(" CampusBot - Spotify Recommendation Prompt (Task 5)");
        System.out.println("=======================================================");
        System.out.println("Generated Prompt:");
        System.out.println(prompt.text());
        System.out.println("=======================================================");

        // Optional: actually call the LLM if an API key is available.
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey != null && !apiKey.isBlank()) {
            ChatLanguageModel model = OpenAiChatModel.builder()
                    .apiKey(apiKey)
                    .modelName("gpt-4o-mini")
                    .temperature(0.8)
                    .build();

            String answer = model.generate(prompt.text());
            System.out.println("AI Recommendations:");
            System.out.println(answer);
        } else {
            System.out.println("(Set OPENAI_API_KEY to also get live song recommendations.)");
        }
    }
}
