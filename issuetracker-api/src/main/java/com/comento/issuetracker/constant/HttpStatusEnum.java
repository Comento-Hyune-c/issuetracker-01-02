package com.comento.issuetracker.constant;

import lombok.Getter;

public enum HttpStatusEnum {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");

    @Getter
    int statusCode;
    @Getter
    String statusMessage;

    HttpStatusEnum(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}