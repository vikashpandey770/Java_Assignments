package com.example.ai;

import okhttp3.*;

public class Task4_HuggingFace {

    public static void main(String[] args) throws Exception {

        String token = System.getenv("HF_TOKEN");

        if (token == null || token.isBlank()) {
            System.out.println("HF_TOKEN environment variable is missing.");
            return;
        }

        String model = "openai-community/gpt2";

        String json = """
                {
                  "inputs": "Java programming is useful because"
                }
                """;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-inference.huggingface.co/models/" + model)
                .post(RequestBody.create(
                        json,
                        MediaType.parse("application/json")
                ))
                .addHeader("Authorization", "Bearer " + token)
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
A public model does not necessarily mean unauthenticated hosted inference.
A Hugging Face token may be required.
*/
