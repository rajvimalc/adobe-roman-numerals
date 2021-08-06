package com.adobe.assessment.romannumerals.framework.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 11:46 PM
 *
 * Global RestControllerAdvice for handling exceptions thrown in the application
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /**
     * Handles ServiceException thrown in the application
     *
     * @param ex ServiceException thrown in the application
     * @return ResponseEntity with error code and message
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ServiceException.ErrorMessage> handleServiceException(Exception ex) {
        final ServiceException serviceException = (ServiceException) ex;
        log.error("Service Exception :: Code: {}, Message: {}",
                serviceException.getErrorMessage().getErrorCode(), serviceException.getErrorMessage().getErrorMessage());
        return new ResponseEntity<>(serviceException.getErrorMessage(), serviceException.getHttpStatus());
    }

}
