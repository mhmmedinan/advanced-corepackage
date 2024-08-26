package io.github.minan65.core_crosscuttingconcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class AuthorizationProblemDetails extends ProblemDetails {
    public AuthorizationProblemDetails() {
        setTitle("Not Authorized");
        setType("http://kodlama.io/exceptions/notauthorized");
        setStatus(HttpStatus.FORBIDDEN.toString());
    }
}
