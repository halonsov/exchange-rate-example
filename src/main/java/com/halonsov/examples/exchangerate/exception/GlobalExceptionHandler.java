package com.halonsov.examples.exchangerate.exception;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.halonsov.examples.exchangerate.controller.response.GeneralResponse;
import com.halonsov.examples.exchangerate.controller.response.enums.StatusEnum;
import com.halonsov.examples.exchangerate.utils.MessageConstants;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Method no handle exception
     *
     * @param ex Execution errors
     * @param headers Headers
     * @param status Status
     * @param request request
     * @return Return message exception
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setErrors(errors);
        generalResponse.setStatus(StatusEnum.ERROR);
        return new ResponseEntity<>(generalResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setErrors(Collections.singletonList(MessageConstants.ERROR_GENERIC));
        generalResponse.setStatus(StatusEnum.ERROR);
        return new ResponseEntity<>(generalResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle generic exception
     *
     * @param req Request
     * @param e Exeption
     * @return Return generic message
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> defaultErrorHandler(HttpServletRequest req, Exception e) {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setErrors(Collections.singletonList(MessageConstants.ERROR_GENERIC));
        generalResponse.setStatus(StatusEnum.ERROR);
        return new ResponseEntity<>(generalResponse, HttpStatus.BAD_REQUEST);
    }
}
