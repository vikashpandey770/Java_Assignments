package com.example.session2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task1_AdviceRawJson {

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

            System.out.println("HTTP Status: " + response.statusCode());
            System.out.println("Raw JSON Response:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Error while calling API: " + e.getMessage());
        }
    }
}
