package com.comento.issuetracker.web.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {

    private int code;
    private String message;
    private T data;

}