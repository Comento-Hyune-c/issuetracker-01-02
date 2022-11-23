package com.comento.issuetracker.web.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Response<T> {

    private int code;
    private String message;
    private T data;

    public static <T> Response ok(T data) {
        return Response.builder()
            .code(HttpStatus.OK.value())
            .message(HttpStatus.OK.name())
            .data(data)
            .build();
    }

}
