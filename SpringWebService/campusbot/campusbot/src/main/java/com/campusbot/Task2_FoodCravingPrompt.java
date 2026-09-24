package com.campusbot;

// ===== TASK 2 =====
// Create a prompt template using LangChain4J that takes a user's food
// craving (e.g., 'I want something spicy') and generates a Zomato-style
// restaurant suggestion. Print the generated prompt to the console.

import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.HashMap;
import java.util.Map;

public class Task2_FoodCravingPrompt {

    public static void main(String[] args) {

        // 1. Define a reusable prompt template with a {{craving}} placeholder.
        PromptTemplate template = PromptTemplate.from(
                "You are CampusBot, a friendly Zomato-style food recommendation assistant.\n" +
                "A user just said: \"{{craving}}\".\n" +
                "Suggest 3 restaurants or dishes nearby that match this craving.\n" +
                "For each suggestion include: Restaurant name, cuisine type, and a 1-line reason why it fits.\n" +
                "Keep the tone casual and food-blogger-like, similar to Zomato reviews."
        );

        // 2. Provide the variable(s) for the template.
        Map<String, Object> variables = new HashMap<>();
        variables.put("craving", "I want something spicy");

        // 3. Apply the variables to generate the final Prompt.
        Prompt prompt = template.apply(variables);

        // 4. Print the generated prompt to the console.
        System.out.println("=======================================================");
        System.out.println(" CampusBot - Food Craving Prompt Template (Task 2)");
        System.out.println("=======================================================");
        System.out.println("User craving   : " + variables.get("craving"));
        System.out.println("-------------------------------------------------------");
        System.out.println("Generated Prompt:");
        System.out.println(prompt.text());
        System.out.println("=======================================================");

        // NOTE: This task only asks to print the generated prompt.
        // To actually send it to OpenAI and get a suggestion back, see
        // Task3_RefundChain.java / Task4_FaqLoop.java for the full LLM call pattern,
        // e.g.:
        //
        //   ChatLanguageModel model = OpenAiChatModel.builder()
        //           .apiKey(System.getenv("OPENAI_API_KEY"))
        //           .modelName("gpt-4o-mini")
        //           .build();
        //   String response = model.generate(prompt.text());
        //   System.out.println(response);
    }
}
