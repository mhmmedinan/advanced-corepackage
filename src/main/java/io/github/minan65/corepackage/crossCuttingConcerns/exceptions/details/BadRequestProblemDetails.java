package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class BadRequestProblemDetails extends ProblemDetails {
    public BadRequestProblemDetails() {
        setTitle("Bad Request");
        setType("http://kodlama.io/exceptions/bad-request");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
