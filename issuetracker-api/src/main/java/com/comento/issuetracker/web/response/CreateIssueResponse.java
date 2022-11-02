package com.comento.issuetracker.web.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateIssueResponse {

    private Long issueId;

}