package com.comento.issuetracker.domain.issueHistory.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueHistoryType {
    ISSUE("ISSUE"),
    ASSIGNEE("ASSIGNEE"),
    LABEL("LABEL"),
    PROJECT("PROJECT"),
    MILESTOEN("MILESTOEN"),
    DEVELOPMENT("DEVELOPMENT");

    private String code;

}
