package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class AuthorizationProblemDetails extends ProblemDetails {
    public AuthorizationProblemDetails() {
        setTitle("Not Authorized");
        setType("http://kodlama.io/exceptions/notauthorized");
        setStatus(HttpStatus.FORBIDDEN.toString());
    }
}
