# CampusBot — LangChain4J Session 4 Assignment

A Java Maven project demonstrating **LangChain4J** + **OpenAI**, covering all
5 tasks from "Session 4 – Building Chatbot with LangChain4J".

## Project Structure

```
campusbot/
├── pom.xml
├── README.md
├── TASK5_REFLECTION.md          <- Task 5 write-up (AI-assisted prompt + reflection)
└── src/main/java/com/campusbot/
    ├── Main.java                 <- Task 1: setup verification
    ├── Task2_FoodCravingPrompt.java   <- Task 2: Zomato-style prompt template
    ├── Task3_RefundChain.java         <- Task 3: single-question Q&A chain
    ├── Task4_FaqLoop.java             <- Task 4: loop over a list of FAQs
    └── Task5_SpotifyPrompt.java       <- Task 5: Spotify recommendation prompt
```

## Prerequisites

- Java 17+ (`java -version`)
- Maven 3.8+ (`mvn -version`)
- An OpenAI API key (only needed for Tasks 3, 4, and optionally 5 — Task 1 & 2
  work without any API key)

## Setup

1. Unzip the project and `cd` into it:
   ```bash
   cd campusbot
   ```

2. Set your OpenAI API key as an environment variable (never hard-code it in
   source):
   ```bash
   # Mac / Linux
   export OPENAI_API_KEY=sk-xxxxxxxxxxxxxxxx

   # Windows (PowerShell)
   setx OPENAI_API_KEY "sk-xxxxxxxxxxxxxxxx"
   ```

3. Build the project (downloads LangChain4J + OpenAI dependencies):
   ```bash
   mvn clean install
   ```

## Running each task

Each task is its own runnable class with a `main()` method.

```bash
# Task 1 — verify LangChain4J is installed correctly
mvn exec:java -Dexec.mainClass="com.campusbot.Main"

# Task 2 — Zomato-style food craving prompt template (no API key needed)
mvn exec:java -Dexec.mainClass="com.campusbot.Task2_FoodCravingPrompt"

# Task 3 — single FAQ question -> OpenAI answer (needs OPENAI_API_KEY)
mvn exec:java -Dexec.mainClass="com.campusbot.Task3_RefundChain"

# Task 4 — loop over multiple FAQ questions (needs OPENAI_API_KEY)
mvn exec:java -Dexec.mainClass="com.campusbot.Task4_FaqLoop"

# Task 5 — Spotify recommendation prompt template (API key optional)
mvn exec:java -Dexec.mainClass="com.campusbot.Task5_SpotifyPrompt"
```

Alternatively, build a runnable fat-jar and run it directly:

```bash
mvn clean package
java -cp target/campusbot.jar com.campusbot.Task4_FaqLoop
```

## Notes

- **LangChain4J** (`dev.langchain4j`) is the Java equivalent of Python's
  LangChain — it wraps LLM providers (OpenAI, Azure, HuggingFace, etc.) behind
  a common Java API, and provides `PromptTemplate` for reusable, variable-based
  prompts.
- The original task hint mentions an `LLMChain` class. That class name is
  specific to the **Python** LangChain library. In LangChain4J the equivalent
  pattern is a `ChatLanguageModel` (e.g. `OpenAiChatModel`) combined with a
  `PromptTemplate` — this is what Tasks 3 and 4 use to reproduce the same
  "template → LLM → answer" chain behavior.
- All API keys are read from the `OPENAI_API_KEY` environment variable —
  never commit real API keys to source control.
