# Task 5 – AI-Assisted Prompt Template for a Spotify Bot

## My original prompt idea (before asking ChatGPT for help)

```
"Recommend some songs for: {{request}}"
```

This was very basic — it just forwarded the user's mood/genre straight to the
model with no structure, no output format, and no way to personalize results.

## Prompt I asked ChatGPT to help improve

> "I'm building a Spotify-style song recommendation bot in LangChain4J using
> a PromptTemplate. Help me write a better prompt template that takes a
> user's mood or genre request and returns a clean, structured list of
> song suggestions."

## Final AI-assisted prompt template

```java
PromptTemplate template = PromptTemplate.from(
        "You are CampusBot, a Spotify-style music recommendation assistant.\n" +
        "User mood/genre request: \"{{request}}\"\n" +
        "User's favorite artist (optional context): \"{{favoriteArtist}}\"\n\n" +
        "Recommend exactly 5 songs that match this request.\n" +
        "For each song, respond in this exact format on one line:\n" +
        "Song Title - Artist Name (Genre) - one short reason it fits the mood\n\n" +
        "Only include real, existing songs. Do not repeat the same artist twice. " +
        "Keep the tone upbeat and playlist-curator-like."
);
```

## One way the AI suggestion improved my original idea

My original prompt just said "recommend some songs" with no structure, so the
model's answers came back as inconsistent, free-form paragraphs that were
hard to parse or display in a UI. ChatGPT's suggestion added a **strict output
format** ("Song Title - Artist Name (Genre) - one short reason") plus an
**exact count constraint** (exactly 5 songs) and a **no-duplicate-artist rule**.
This one change made the biggest difference: the AI-generated answers became
predictable and machine-parseable (easy to split on `" - "` and render as a
list of cards in a front-end), instead of unpredictable prose that I'd have to
manually clean up every time.

A second, smaller improvement: adding an optional `{{favoriteArtist}}`
variable let the bot personalize recommendations using context, similar to
how real Spotify recommendations factor in listening history.
