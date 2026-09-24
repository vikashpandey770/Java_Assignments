# Java AI APIs - Session 1

Simple solutions for Tasks 1 to 5.

## Setup
1. Open this folder as a Maven project in IntelliJ/Eclipse.
2. Use Java 17+.
3. Maven downloads OkHttp automatically.
4. Put API credentials in environment variables, not in source code.

Environment variables:
- OPENAI_API_KEY
- HF_TOKEN
- GOOGLE_ACCESS_TOKEN
- GOOGLE_CLOUD_PROJECT

## Important
The assignment mentions OpenAI `text-davinci-003`. That legacy model is retired.
Task 2 therefore uses the current OpenAI Responses API with a current model,
while keeping the same POST-request learning objective.

Never upload real API keys to GitHub.
