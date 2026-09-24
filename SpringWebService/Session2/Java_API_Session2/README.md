# Java API Session 2

Complete solutions for Tasks 1 to 5.

## Technologies
- Java 17+
- Maven
- Java HttpClient
- Jackson ObjectMapper
- OpenWeatherMap REST API

## Project structure

src/main/java/com/example/session2/
    Task1_AdviceRawJson.java
    Task2_AdviceParser.java
    Task3_JokeParser.java
    Task4_GenericJsonClient.java
    Task5_AhmedabadWeather.java

## How to run

1. Open this folder in IntelliJ IDEA/Eclipse as a Maven project.
2. Wait for Maven to download Jackson.
3. Run each Java class separately.

## Task 5 API key

Do NOT put your real OpenWeatherMap API key directly in source code.

Set:
OPENWEATHER_API_KEY=your_api_key

The Java program reads it using System.getenv("OPENWEATHER_API_KEY").

For OpenWeatherMap, use your own valid free-tier API key from your account.
