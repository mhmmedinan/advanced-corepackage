package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.details;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> errors;

    public ValidationProblemDetails() {
        setTitle("Validation Exception");
        setType("https://kodlama.io/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
        setDetail("Validation Rule Problems");
    }
}