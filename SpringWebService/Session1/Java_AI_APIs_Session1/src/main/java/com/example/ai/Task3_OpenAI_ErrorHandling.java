package com.example.ai;

import okhttp3.*;

public class Task3_OpenAI_ErrorHandling {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("ERROR: OpenAI API key is missing.");
            return;
        }

        String json = """
                {
                  "model": "gpt-5.6-mini",
                  "input": "Give me one short food caption."
                }
                """;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/responses")
                .post(RequestBody.create(
                        json,
                        MediaType.parse("application/json")
                ))
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {

            String result = response.body() != null
                    ? response.body().string()
                    : "No response body";

            if (response.isSuccessful()) {
                System.out.println("Success:");
                System.out.println(result);
            } else {
                System.out.println("Request failed.");
                System.out.println("HTTP Status: " + response.code());

                if (response.code() == 401) {
                    System.out.println("Custom message: Invalid or missing API key.");
                } else if (response.code() == 429) {
                    System.out.println("Custom message: Rate limit/quota exceeded.");
                } else if (response.code() >= 500) {
                    System.out.println("Custom message: API server error.");
                } else {
                    System.out.println("Custom message: Check request and API error.");
                }

                System.out.println("API response: " + result);
            }
        }
    }
}
