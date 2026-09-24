package com.example.session2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task2_AdviceParser {

    public static void main(String[] args) {

        String url = "https://api.adviceslip.com/advice";

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

                String advice = root
                        .path("slip")
                        .path("advice")
                        .asText();

                System.out.println("Advice: " + advice);

            } else {
                System.out.println("API Error. HTTP Status: "
                        + response.statusCode());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
