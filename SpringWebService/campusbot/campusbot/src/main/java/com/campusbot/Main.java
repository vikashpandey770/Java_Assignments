package com.campusbot;

// ===== TASK 1 =====
// Set up a new Java Maven project and add the LangChain4J and OpenAI
// dependencies to pom.xml. Verify installation by importing LangChain4J
// classes here and running a simple print statement.

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

public class Main {

    public static void main(String[] args) {

        // If these imports resolve and the project compiles, LangChain4J
        // and the OpenAI module are correctly installed.
        System.out.println("=======================================================");
        System.out.println(" CampusBot - LangChain4J Setup Verification (Task 1)");
        System.out.println("=======================================================");
        System.out.println("LangChain4J classes imported successfully:");
        System.out.println(" - " + ChatLanguageModel.class.getName());
        System.out.println(" - " + OpenAiChatModel.class.getName());
        System.out.println(" - " + Prompt.class.getName());
        System.out.println(" - " + PromptTemplate.class.getName());
        System.out.println();
        System.out.println("Setup OK! LangChain4J + OpenAI dependencies are working.");
        System.out.println();

        System.out.println(">>> Run other tasks individually:");
        System.out.println("    mvn exec:java -Dexec.mainClass=\"com.campusbot.Task2_FoodCravingPrompt\"");
        System.out.println("    mvn exec:java -Dexec.mainClass=\"com.campusbot.Task3_RefundChain\"");
        System.out.println("    mvn exec:java -Dexec.mainClass=\"com.campusbot.Task4_FaqLoop\"");
        System.out.println("    mvn exec:java -Dexec.mainClass=\"com.campusbot.Task5_SpotifyPrompt\"");
    }
}
