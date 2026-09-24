package com.moviebot.model;

/**
 * ===== TASK 2 / TASK 3 =====
 * Uniform response body returned by /askMovieBot, for both success and
 * error cases (Task 3: missing/invalid API key, non-200 OpenAI responses).
 */
public class MovieBotResponse {

    private String question;
    private String answer;
    private boolean success;
    private String error;

    public MovieBotResponse() {
    }

    public static MovieBotResponse success(String question, String answer) {
        MovieBotResponse response = new MovieBotResponse();
        response.question = question;
        response.answer = answer;
        response.success = true;
        return response;
    }

    public static MovieBotResponse failure(String question, String error) {
        MovieBotResponse response = new MovieBotResponse();
        response.question = question;
        response.success = false;
        response.error = error;
        return response;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
