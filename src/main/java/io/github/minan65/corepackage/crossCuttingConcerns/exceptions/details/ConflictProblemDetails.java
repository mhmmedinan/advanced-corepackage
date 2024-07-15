package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class ConflictProblemDetails extends ProblemDetails {
    public ConflictProblemDetails() {
        setTitle("Conflict");
        setType("http://kodlama.io/exceptions/conflict");
        setStatus(HttpStatus.CONFLICT.toString());
    }
}
