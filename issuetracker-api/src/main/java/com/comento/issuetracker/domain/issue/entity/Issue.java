package com.comento.issuetracker.domain.issue.entity;

import com.comento.issuetracker.web.request.CreateIssueRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "issue")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Long issueId;

    @Column(name = "issue_title", nullable = false)
    private String issueTitle;

    @Column(name = "issue_desc", nullable = false)
    private String issueDesc;

    public Issue() {

    }

    public Issue(CreateIssueRequest request) {
        this.issueTitle = request.getIssueTitle();
        this.issueDesc = request.getIssueDesc();
    }

}