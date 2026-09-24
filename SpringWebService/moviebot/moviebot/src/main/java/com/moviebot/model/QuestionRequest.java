package com.moviebot.model;

import jakarta.validation.constraints.NotBlank;

/**
 * ===== TASK 2 =====
 * Request body for POST /askMovieBot
 * Expected JSON: { "question": "Suggest a good sci-fi movie" }
 */
public class QuestionRequest {

    @NotBlank(message = "'question' field must not be empty")
    private String question;

    public QuestionRequest() {
    }

    public QuestionRequest(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
