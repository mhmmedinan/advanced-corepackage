package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class ConflictProblemDetails extends ProblemDetails {
    public ConflictProblemDetails() {
        setTitle("Conflict");
        setType("http://kodlama.io/exceptions/conflict");
        setStatus(HttpStatus.CONFLICT.toString());
    }
}
