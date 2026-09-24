# Task 4 – AI-Assisted OpenAI HTTP POST Code

## Prompt given to ChatGPT / Copilot

> "Write Java code to send an HTTP POST request to the OpenAI chat
> completions API (https://api.openai.com/v1/chat/completions) from a
> Spring Boot service, including the Authorization header with a Bearer
> API key, and parse the response to get the assistant's reply."

## What the AI generated (first draft, simplified)

```java
RestTemplate restTemplate = new RestTemplate();

HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
headers.setBearerAuth(apiKey);

Map<String, Object> body = new HashMap<>();
body.put("model", "gpt-4o-mini");
body.put("messages", List.of(Map.of("role", "user", "content", question)));

HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

ResponseEntity<Map> response = restTemplate.postForEntity(
        "https://api.openai.com/v1/chat/completions", entity, Map.class);

Map choice = ((List<Map>) response.getBody().get("choices")).get(0);
Map message = (Map) choice.get("message");
String answer = (String) message.get("content");
```

## How I adapted it to fit MovieBot's Spring Boot controller

1. **Switched `RestTemplate` → `WebClient`.** `RestTemplate` is in
   maintenance mode in modern Spring; the rest of the project already uses
   `spring-boot-starter-webflux`, so `OpenAiService` uses a shared
   `WebClient` bean (`WebClientConfig`) instead of creating a new
   `RestTemplate` per call.
2. **Externalized config.** The API key, endpoint URL, and model name were
   hard-coded in the AI's draft. I moved them into
   `application.properties` (`openai.api.key`, `openai.api.url`,
   `openai.api.model`) and injected them with `@Value`, per Task 1's
   requirement to store the key securely (as an env-var-backed property,
   not committed to source).
3. **Added a system prompt.** The draft only sent the raw user question. I
   added a `"role": "system"` message so the bot consistently behaves like
   a *movie* assistant rather than a generic chatbot.
4. **Added Task 3's error handling.** The AI's draft didn't handle
   non-200 responses at all — a bad key would just throw an unhandled
   `RestClientException` and crash the request with a raw 500. I wrapped
   the call in a try/catch for `WebClientResponseException`, mapped known
   OpenAI status codes (401 → invalid key, 429 → rate limit, 400 → bad
   request) to friendly messages, and threw a custom `OpenAiApiException`
   that the controller turns into a clean JSON error response with the
   correct HTTP status code.
5. **Pre-flight key check.** Before even calling OpenAI, `getMovieAnswer()`
   checks if `apiKey` is blank and immediately throws a 401
   `OpenAiApiException` — this satisfies Task 3's "missing API key" case
   without wasting an HTTP call.

## Final result

The AI-generated snippet was a good *starting point* for the OpenAI POST
call itself, but needed real adaptation to fit the project's existing
`WebClient` setup, externalized configuration, and the layered
error-handling required by Task 3. The final version lives in
`src/main/java/com/moviebot/service/OpenAiService.java`.
