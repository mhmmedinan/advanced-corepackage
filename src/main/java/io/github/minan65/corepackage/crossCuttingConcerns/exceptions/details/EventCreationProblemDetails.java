package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.details;

import org.springframework.http.HttpStatus;

public class EventCreationProblemDetails extends ProblemDetails{

    public EventCreationProblemDetails(){
        setTitle("Event Creation");
        setType("http://kodlama.io/exceptions/eventcreation");
    }
}
