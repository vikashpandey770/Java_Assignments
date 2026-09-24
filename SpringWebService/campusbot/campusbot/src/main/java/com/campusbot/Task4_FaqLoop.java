package com.campusbot;

// ===== TASK 4 =====
// Refactor the chain code to accept a list of FAQ questions and print the
// AI-generated answer for each question.
// Constraint: Use a loop to process all questions without repeating code.

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4_FaqLoop {

    public static void main(String[] args) {

        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("ERROR: Please set the OPENAI_API_KEY environment variable first.");
            System.out.println("  Mac/Linux : export OPENAI_API_KEY=sk-xxxx");
            System.out.println("  Windows   : setx OPENAI_API_KEY \"sk-xxxx\"");
            return;
        }

        // 1. Build the model once and reuse it for every question (no repeated setup).
        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .temperature(0.7)
                .build();

        // 2. One reusable prompt template for every FAQ.
        PromptTemplate template = PromptTemplate.from(
                "You are CampusBot, a helpful customer-support assistant for Indian " +
                "apps and services. Answer the following user question clearly and " +
                "concisely, in simple steps if needed.\n\nQuestion: {{question}}"
        );

        // 3. The list of FAQ questions to process.
        List<String> faqQuestions = Arrays.asList(
                "How do I get a refund on Flipkart?",
                "How to use Paytm wallet?",
                "How to book a movie on BookMyShow?",
                "How do I track my Swiggy order?",
                "How to reset my password on Amazon India?"
        );

        System.out.println("=======================================================");
        System.out.println(" CampusBot - FAQ Batch Processor (Task 4)");
        System.out.println("=======================================================");

        // 4. Loop through every question, generating each answer with the SAME
        //    model + template — no code duplication.
        int count = 1;
        for (String question : faqQuestions) {

            Map<String, Object> variables = new HashMap<>();
            variables.put("question", question);
            Prompt prompt = template.apply(variables);

            String answer = model.generate(prompt.text());

            System.out.println();
            System.out.println("[" + count + "] Question: " + question);
            System.out.println("    Answer  : " + answer);
            System.out.println("-------------------------------------------------------");

            count++;
        }

        System.out.println("=======================================================");
        System.out.println("Processed " + faqQuestions.size() + " FAQ questions.");
    }
}
