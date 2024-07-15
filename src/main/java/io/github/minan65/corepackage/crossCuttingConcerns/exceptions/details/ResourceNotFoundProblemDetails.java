package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundProblemDetails extends ProblemDetails {
    public ResourceNotFoundProblemDetails() {
        setTitle("Resource Not Found");
        setType("http://kodlama.io/exceptions/resource-not-found");
        setStatus(HttpStatus.NOT_FOUND.toString());
    }
}
