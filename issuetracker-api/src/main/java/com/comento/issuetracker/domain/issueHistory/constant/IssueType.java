package com.comento.issuetracker.domain.issueHistory.constant;

import lombok.Getter;

@Getter
public enum IssueType {
    ISSUE("ISSUE"),
    ASSIGNEE("ASSIGNEE"),
    LABEL("LABEL"),
    PROJECT("PROJECT"),
    MILESTOEN("MILESTOEN"),
    DEVELOPMENT("DEVELOPMENT");

    private String code;

    IssueType(String code) {
        this.code = code;
    }

}