package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class UnauthorizedProblemDetails extends ProblemDetails {
    public UnauthorizedProblemDetails() {
        setTitle("Unauthorized");
        setType("http://kodlama.io/exceptions/unauthorized");
        setStatus(HttpStatus.UNAUTHORIZED.toString());
    }
}
