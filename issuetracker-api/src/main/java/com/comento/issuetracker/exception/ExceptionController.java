package com.comento.issuetracker.exception;

import static org.springframework.http.HttpStatus.*;

import com.comento.issuetracker.web.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.info("MethodArgumentNotValidException => {}", exception.getBindingResult());

        return Response.builder()
            .code(BAD_REQUEST.value())
            .message(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
            .build();
    }

}