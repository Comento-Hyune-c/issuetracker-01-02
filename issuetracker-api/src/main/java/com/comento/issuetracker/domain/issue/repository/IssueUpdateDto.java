package com.comento.issuetracker.domain.issue.repository;

import lombok.Data;
import lombok.Getter;

@Getter
public class IssueUpdateDto {
    private String issueTitle;


    public IssueUpdateDto() {
    }

    public IssueUpdateDto(String issueTitle) {
        this.issueTitle = issueTitle;
    }
}
