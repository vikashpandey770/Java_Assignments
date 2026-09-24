# MovieBot — Session 3: OpenAI API + Spring Boot Integration

A Spring Boot REST API that exposes a `/askMovieBot` endpoint, which
forwards a user's question to the OpenAI Chat Completions API and returns
the AI's answer. Covers all 4 tasks from "Session 3 – Integrating OpenAI
API with Spring Boot & FastAPI".

## Project Structure

```
moviebot/
├── pom.xml
├── README.md
├── TASK4_REFLECTION.md                 <- Task 4 write-up (AI-assisted code + adaptation)
└── src/main/java/com/moviebot/
    ├── MovieBotApplication.java         <- Spring Boot entry point
    ├── controller/
    │   └── MovieBotController.java      <- Task 2 & 3: POST /askMovieBot + error handling
    ├── service/
    │   └── OpenAiService.java           <- Task 2, 3 & 4: OpenAI HTTP call + error mapping
    ├── model/
    │   ├── QuestionRequest.java         <- Request DTO { "question": "..." }
    │   └── MovieBotResponse.java        <- Response DTO (success/error)
    ├── exception/
    │   └── OpenAiApiException.java      <- Custom exception carrying HTTP status
    └── config/
        └── WebClientConfig.java         <- WebClient bean used to call OpenAI
└── src/main/resources/
    └── application.properties           <- Task 1: API key config (via env var)
```

## Prerequisites

- Java 17+
- Maven 3.8+
- An OpenAI API key from https://platform.openai.com/api-keys

## Setup (Task 1)

1. Unzip the project and `cd` into it:
   ```bash
   cd moviebot
   ```

2. Sign up / log in at https://platform.openai.com and generate a new
   secret API key under **API Keys**.

3. **Never paste the key directly into `application.properties`.** Instead,
   set it as an environment variable — `application.properties` already
   reads it via `${OPENAI_API_KEY:}`:
   ```bash
   # Mac / Linux
   export OPENAI_API_KEY=sk-xxxxxxxxxxxxxxxx

   # Windows (PowerShell)
   setx OPENAI_API_KEY "sk-xxxxxxxxxxxxxxxx"
   ```

4. Build the project:
   ```bash
   mvn clean install
   ```

## Running the app

```bash
mvn spring-boot:run
```

The server starts on `http://localhost:8080`.

## Testing the endpoint (Task 2)

```bash
curl -X POST http://localhost:8080/askMovieBot \
  -H "Content-Type: application/json" \
  -d '{"question": "Suggest a good sci-fi movie from the last 5 years"}'
```

Successful response:
```json
{
  "question": "Suggest a good sci-fi movie from the last 5 years",
  "answer": "You might enjoy 'Dune' (2021)...",
  "success": true,
  "error": null
}
```

## Testing error handling (Task 3)

**Missing/invalid API key** — unset `OPENAI_API_KEY` (or set it to garbage)
and restart the app, then hit the same endpoint:
```json
{
  "question": "Suggest a good sci-fi movie",
  "answer": null,
  "success": false,
  "error": "OpenAI API key is missing. Set the OPENAI_API_KEY environment variable."
}
```
This returns HTTP `401 Unauthorized`.

**Non-200 codes from OpenAI** (e.g. rate limit, bad request) are caught via
`WebClientResponseException` in `OpenAiService` and mapped to friendly
error messages with the matching HTTP status code (see
`OpenAiService.getMovieAnswer()`).

**Empty/missing "question" field** returns HTTP `400 Bad Request`:
```bash
curl -X POST http://localhost:8080/askMovieBot \
  -H "Content-Type: application/json" \
  -d '{"question": ""}'
```

## Notes

- The OpenAI HTTP call is made with Spring's reactive `WebClient` (Task 4
  — see `TASK4_REFLECTION.md` for how the AI-generated draft was adapted).
- All secrets are read from environment variables — nothing sensitive is
  hard-coded or committed to source control.
