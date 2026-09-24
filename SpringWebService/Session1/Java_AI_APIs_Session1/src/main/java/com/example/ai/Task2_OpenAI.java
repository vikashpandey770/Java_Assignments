package com.example.ai;

import okhttp3.*;

public class Task2_OpenAI {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("OPENAI_API_KEY environment variable is missing.");
            return;
        }

        String json = """
                {
                  "model": "gpt-5.6-mini",
                  "input": "Suggest 3 creative Instagram captions for a food photo"
                }
                """;

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/responses")
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("HTTP Status: " + response.code());
            System.out.println(response.body() != null
                    ? response.body().string()
                    : "No response body");
        }
    }
}

/*
Note:
The old text-davinci-003 model is retired.
This example uses the current Responses API.
*/
