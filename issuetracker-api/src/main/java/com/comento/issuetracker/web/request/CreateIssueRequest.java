package com.comento.issuetracker.web.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateIssueRequest {

    @NotBlank(message = "제목을 입력해주세요.")
    private String issueTitle;
    @NotBlank(message = "설명을 입력해주세요.")
    private String issueDesc;

}