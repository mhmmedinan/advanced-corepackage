package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class RateLimitExceededProblemDetails extends ProblemDetails {
    public RateLimitExceededProblemDetails() {
        setTitle("Rate Limit Exceeded");
        setType("http://kodlama.io/exceptions/rate-limit-exceeded");
        setStatus(HttpStatus.TOO_MANY_REQUESTS.toString());
    }
}

