package com.example.ai;

import okhttp3.*;

public class Task5_VertexAI {

    public static void main(String[] args) throws Exception {

        String accessToken = System.getenv("GOOGLE_ACCESS_TOKEN");
        String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");

        if (accessToken == null || accessToken.isBlank()) {
            System.out.println("GOOGLE_ACCESS_TOKEN environment variable is missing.");
            return;
        }

        if (projectId == null || projectId.isBlank()) {
            System.out.println("GOOGLE_CLOUD_PROJECT environment variable is missing.");
            return;
        }

        String location = "us-central1";
        String model = "gemini-2.5-flash";

        String url = "https://" + location
                + "-aiplatform.googleapis.com/v1/projects/"
                + projectId
                + "/locations/" + location
                + "/publishers/google/models/" + model
                + ":generateContent";

        String json = """
                {
                  "contents": [
                    {
                      "role": "user",
                      "parts": [
                        {
                          "text": "Explain Java OOP in 3 simple points."
                        }
                      ]
                    }
                  ]
                }
                """;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(
                        json,
                        MediaType.parse("application/json")
                ))
                .addHeader("Authorization", "Bearer " + accessToken)
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
AI assistance documentation is in Task5_AI_Prompt.txt.
*/
