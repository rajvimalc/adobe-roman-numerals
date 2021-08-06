package com.adobe.assessment.romannumerals.framework.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 11:34 PM
 *
 * Service Exception class which handles exceptions thrown in the application
 */
@Getter
public class ServiceException extends RuntimeException {

    /**
     * HttpStatus code for the service exception thrown
     */
    private final HttpStatus httpStatus;

    /**
     * Error code and message for the service exception thrown
     */
    private final ErrorMessage errorMessage;

    public ServiceException(String code, String message) {
        super(message);
        this.errorMessage = new ErrorMessage(code, message);
        // Defaults to INTERNAL_SERVER_ERROR in no HttpStatus given
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ServiceException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorMessage = new ErrorMessage(code, message);
    }

    /**
     * Error code and message object for error responses
     */
    @Data
    public static class ErrorMessage {
        private final String errorCode;
        private final String errorMessage;
    }

}
