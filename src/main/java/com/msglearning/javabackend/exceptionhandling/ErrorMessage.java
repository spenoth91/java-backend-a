package com.msglearning.javabackend.exceptionhandling;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;


    @Data
    @JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
    @JsonTypeIdResolver(LowerCaseClassNameResolver.class)
    public
    class ErrorMessage {

        private HttpStatus status;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime timestamp;
        private String message;
        private String debugMessage;


        private ErrorMessage() {
            timestamp = LocalDateTime.now();
        }

        public ErrorMessage(HttpStatus status) {
            this();
            this.status = status;
        }

        public ErrorMessage(HttpStatus status, Throwable ex) {
            this();
            this.status = status;
            this.message = "Unexpected error";
            this.debugMessage = ex.getLocalizedMessage();
        }

        public ErrorMessage(HttpStatus status, String message, Throwable ex) {
            this();
            this.status = status;
            this.message = message;
            this.debugMessage = ex.getLocalizedMessage();
        }


        /*private void addValidationError(String object, String field, Object rejectedValue, String message) {
            addSubError(new ApiValidationError(object, field, rejectedValue, message));
        }

        private void addValidationError(String object, String message) {
            addSubError(new ApiValidationError(object, message));
        }

        private void addValidationError(FieldError fieldError) {
            this.addValidationError(
                    fieldError.getObjectName(),
                    fieldError.getField(),
                    fieldError.getRejectedValue(),
                    fieldError.getDefaultMessage());
        }

        public void addValidationErrors(List<FieldError> fieldErrors) {
            fieldErrors.forEach(this::addValidationError);
        }

        private void addValidationError(ObjectError objectError) {
            this.addValidationError(
                    objectError.getObjectName(),
                    objectError.getDefaultMessage());
        }

        public void addValidationError(List<ObjectError> globalErrors) {
            globalErrors.forEach(this::addValidationError);
        }


        private void addValidationError(ConstraintViolation<?> cv) {
            this.addValidationError(
                    cv.getRootBeanClass().getSimpleName(),
                    ((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
                    cv.getInvalidValue(),
                    cv.getMessage());
        }

        public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
            constraintViolations.forEach(this::addValidationError);
        }        }
*/


    }


