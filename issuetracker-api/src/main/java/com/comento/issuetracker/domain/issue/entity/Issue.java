package com.comento.issuetracker.domain.issue.entity;

import com.comento.issuetracker.web.request.IssueCreateRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "issue")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Long issueId;

    @Column(name = "issue_title", nullable = false)
    private String issueTitle;

    @Column(name = "issue_desc", nullable = false)
    private String issueDesc;

    @Column(nullable = false)
    private String useYn;

    @Column(nullable = false)
    private LocalDateTime regAt;
}