package pro.sky.Homework2_6.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNameValidationException extends RuntimeException{
    public EmployeeNameValidationException(String message) {
        super(message);}
}
