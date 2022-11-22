package com.comento.issuetracker.web.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IssueAssigneeRequest {

    @NotBlank(message = "이슈를 입력해주세요.")
    private Long issueId;
    @NotBlank(message = "사용자를 입력해주세요.")
    private Long userId;

}
