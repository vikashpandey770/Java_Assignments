package com.moviebot.controller;

import com.moviebot.exception.OpenAiApiException;
import com.moviebot.model.MovieBotResponse;
import com.moviebot.model.QuestionRequest;
import com.moviebot.service.OpenAiService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ===== TASK 2 & 3 =====
 *
 * REST controller exposing POST /askMovieBot.
 *
 * Request  : { "question": "Suggest a good sci-fi movie" }
 * Response (success): { "question": "...", "answer": "...", "success": true }
 * Response (error)  : { "question": "...", "success": false, "error": "..." }
 */
@RestController
public class MovieBotController {

    private final OpenAiService openAiService;

    public MovieBotController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping("/askMovieBot")
    public ResponseEntity<MovieBotResponse> askMovieBot(@Valid @RequestBody QuestionRequest request) {
        try {
            // ---- Task 2: call OpenAI with the question and return the answer ----
            String answer = openAiService.getMovieAnswer(request.getQuestion());
            return ResponseEntity.ok(MovieBotResponse.success(request.getQuestion(), answer));

        } catch (OpenAiApiException ex) {
            // ---- Task 3: missing/invalid key or non-200 OpenAI response ----
            HttpStatus status = HttpStatus.resolve(ex.getStatusCode().value());
            if (status == null) {
                status = HttpStatus.BAD_GATEWAY;
            }
            return ResponseEntity
                    .status(status)
                    .body(MovieBotResponse.failure(request.getQuestion(), ex.getMessage()));
        }
    }

    /**
     * Handles validation errors (e.g. blank/missing "question" field)
     * so the client gets a clean 400 response instead of a stack trace.
     */
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<MovieBotResponse> handleValidationError(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().isEmpty()
                ? "Invalid request."
                : ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity
                .badRequest()
                .body(MovieBotResponse.failure(null, message));
    }
}
