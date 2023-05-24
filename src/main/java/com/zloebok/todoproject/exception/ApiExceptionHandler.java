package com.zloebok.todoproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiException handleApiRequestException(ApiRequestNotFoundException e, WebRequest request) {
        return ApiException.builder()
                .message(e.getMessage())
                .httpPath(request.getDescription(false))
                .httpStatus(HttpStatus.NOT_FOUND)
                .timestamp(ZonedDateTime.now())
                .build();
    }


}
