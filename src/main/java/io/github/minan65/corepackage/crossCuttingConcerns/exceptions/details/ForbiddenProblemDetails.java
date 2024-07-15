package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class ForbiddenProblemDetails extends ProblemDetails {
    public ForbiddenProblemDetails() {
        setTitle("Forbidden");
        setType("http://kodlama.io/exceptions/forbidden");
        setStatus(HttpStatus.FORBIDDEN.toString());
    }
}
