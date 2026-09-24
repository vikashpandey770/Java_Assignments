package com.example.session2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task3_JokeParser {

    public static void main(String[] args) {

        String url =
                "https://official-joke-api.appspot.com/random_joke";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() == 200) {

                ObjectMapper objectMapper = new ObjectMapper();

                JsonNode root = objectMapper.readTree(response.body());

                String setup = root.path("setup").asText();
                String punchline = root.path("punchline").asText();

                System.out.println("Setup: " + setup);
                System.out.println("Punchline: " + punchline);

            } else {
                System.out.println("API Error. HTTP Status: "
                        + response.statusCode());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
