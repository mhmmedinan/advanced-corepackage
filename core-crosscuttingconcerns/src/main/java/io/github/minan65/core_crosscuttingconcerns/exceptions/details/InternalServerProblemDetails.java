package io.github.minan65.core_crosscuttingconcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class InternalServerProblemDetails extends ProblemDetails {
    public InternalServerProblemDetails(){
        setTitle("Internal Server Error");
        setType("http://kodlama.io/exceptions/internalservererror");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}