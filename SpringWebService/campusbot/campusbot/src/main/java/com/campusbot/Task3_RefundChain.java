package com.campusbot;

// ===== TASK 3 =====
// Build a simple chain in LangChain4J that takes a user's question like
// 'How do I get a refund on Flipkart?' and returns a helpful answer using
// the OpenAI LLM. Display both the input question and the AI's answer.
//
// NOTE ON THE HINT: Older Python-style LangChain has a class called
// "LLMChain". LangChain4J (the Java port) does not ship a class with that
// exact name — the equivalent building block is a ChatLanguageModel
// (here, OpenAiChatModel) combined with a PromptTemplate. That combo is
// what we use below to reproduce the same "chain" behavior: template -> LLM -> answer.

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.HashMap;
import java.util.Map;

public class Task3_RefundChain {

    public static void main(String[] args) {

        // 1. Read the API key from an environment variable (never hard-code it!)
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("ERROR: Please set the OPENAI_API_KEY environment variable first.");
            System.out.println("  Mac/Linux : export OPENAI_API_KEY=sk-xxxx");
            System.out.println("  Windows   : setx OPENAI_API_KEY \"sk-xxxx\"");
            return;
        }

        // 2. Build the OpenAI chat model (this is the "LLM" part of the chain).
        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .temperature(0.7)
                .build();

        // 3. Build a prompt template (this is the "Prompt" part of the chain).
        PromptTemplate template = PromptTemplate.from(
                "You are CampusBot, a helpful customer-support assistant for Indian " +
                "e-commerce and shopping apps. Answer the following user question " +
                "clearly, in simple steps if needed.\n\nQuestion: {{question}}"
        );

        String question = "How do I get a refund on Flipkart?";

        Map<String, Object> variables = new HashMap<>();
        variables.put("question", question);
        Prompt prompt = template.apply(variables);

        // 4. Run the "chain": template -> model -> answer
        String answer = model.generate(prompt.text());

        // 5. Display both the input question and the AI's answer.
        System.out.println("=======================================================");
        System.out.println(" CampusBot - Simple Q&A Chain (Task 3)");
        System.out.println("=======================================================");
        System.out.println("Question: " + question);
        System.out.println("-------------------------------------------------------");
        System.out.println("Answer  : " + answer);
        System.out.println("=======================================================");
    }
}
