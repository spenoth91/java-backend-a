package com.msglearning.javabackend.exceptionhandling;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ErrorMessage errorMessage) {
        return new ResponseEntity<>(errorMessage, errorMessage.getStatus());
    }
    /**
     * Handles ValidationException.
     *
     * @param ex the EntityNotFoundException
     * @return the ApiError object
     */
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            ValidationException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST);
        errorMessage.setMessage(ex.getMessage());
        return buildResponseEntity(errorMessage);
    }

    /**
     * Handles NotFoundException.
     *
     * @param ex the EntityNotFoundException
     * @return the ApiError object
     */
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            NotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND);
        errorMessage.setMessage(ex.getMessage());
        return buildResponseEntity(errorMessage);
    }

    //other exception handlers below

}
