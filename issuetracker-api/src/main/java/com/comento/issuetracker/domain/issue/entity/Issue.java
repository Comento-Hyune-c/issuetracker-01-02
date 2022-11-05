package com.comento.issuetracker.domain.issue.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Issue {

    @Id @GeneratedValue
    @Column(name = "issue_id")
    private Long id;

    @Column(name = "issue_title")
    private String title;

    @Column(name = "issue_desc")
    private String desc;
}
