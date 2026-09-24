package com.example.session2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task5_AhmedabadWeather {

    public static void main(String[] args) {

        String apiKey = System.getenv("OPENWEATHER_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println(
                    "OPENWEATHER_API_KEY environment variable is missing."
            );
            System.out.println(
                    "Set your OpenWeatherMap API key first."
            );
            return;
        }

        String city = "Ahmedabad";
        String url = "https://api.openweathermap.org/data/2.5/weather"
                + "?q=" + city
                + "&appid=" + apiKey
                + "&units=metric";

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

                JsonNode root =
                        objectMapper.readTree(response.body());

                double temperature =
                        root.path("main")
                                .path("temp")
                                .asDouble();

                String description =
                        root.path("weather")
                                .path(0)
                                .path("description")
                                .asText();

                System.out.println("City: Ahmedabad");
                System.out.println(
                        "Temperature: " + temperature + " °C"
                );
                System.out.println(
                        "Weather: " + description
                );

            } else {

                System.out.println(
                        "OpenWeatherMap API Error"
                );

                System.out.println(
                        "HTTP Status: "
                                + response.statusCode()
                );

                System.out.println(
                        "Response: " + response.body()
                );
            }

        } catch (Exception e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}

/*
AI-generated coding assistance was used for this example.
See Task5_AI_Prompt.txt.
*/
