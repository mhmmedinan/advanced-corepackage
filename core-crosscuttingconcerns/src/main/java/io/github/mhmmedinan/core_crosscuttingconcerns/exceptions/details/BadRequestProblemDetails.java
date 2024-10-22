package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class BadRequestProblemDetails extends ProblemDetails {
    public BadRequestProblemDetails() {
        setTitle("Bad Request");
        setType("http://kodlama.io/exceptions/bad-request");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
