package com.comento.issuetracker.web.response;

import com.comento.issuetracker.constant.HttpStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private int code;
    private String message;
    private Object data;

    public ErrorResponse() {
        this.code = HttpStatusEnum.BAD_REQUEST.getStatusCode();
        this.message = HttpStatusEnum.BAD_REQUEST.getStatusMessage();
        this.data = null;
    }

    public ErrorResponse(Object data) {
        this.code = HttpStatusEnum.OK.getStatusCode();
        this.message = HttpStatusEnum.OK.getStatusMessage();
        this.data = data;
    }

    public ErrorResponse(HttpStatusEnum status, Object data) {
        this.code = status.getStatusCode();
        this.message = status.getStatusMessage();
        this.data = data;
    }
}