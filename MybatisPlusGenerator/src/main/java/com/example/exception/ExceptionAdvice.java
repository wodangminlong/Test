package com.example.exception;

import com.example.util.ApiErrorCode;
import com.example.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * exception advice utils
 *
 * @author dml
 * @date 2021/05/07 17:58
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiResponse handleWebExchangeBindException(WebExchangeBindException e) {
        List<FieldError> violations = e.getFieldErrors();
        StringBuilder strBuilder = new StringBuilder();
        for (FieldError fieldError : violations) {
            strBuilder.append(fieldError.getField()).append(" ").append(fieldError.getDefaultMessage()).append(";");
        }
        String result = strBuilder.toString();
        log.error("ExceptionAdvice handleWebExchangeBindException: {}", result);
        return ApiResponse.error(ApiErrorCode.PARAMETER_ERROR, result);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiResponse handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            strBuilder.append(violation.getPropertyPath()).append(" ").append(violation.getMessage()).append(";");
        }
        String result = strBuilder.toString();
        log.error("ExceptionAdvice handleConstraintViolationException: {}", result);
        return ApiResponse.error(ApiErrorCode.PARAMETER_ERROR, result);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleCustomException(Exception e) {
        log.error("handleCustomException: ", e.fillInStackTrace());
        return ApiResponse.error();
    }



}
