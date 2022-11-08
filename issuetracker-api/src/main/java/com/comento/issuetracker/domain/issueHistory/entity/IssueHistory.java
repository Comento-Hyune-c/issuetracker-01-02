package com.comento.issuetracker.domain.issueHistory.entity;

import com.comento.issuetracker.domain.issueHistory.constant.IssueType;
import com.comento.issuetracker.domain.issueHistory.converter.IssueTypeConverter;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
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
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "issue_history")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class IssueHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_history_id")
    private Long issueHistoryId;

    @Column(name = "issue_id")
    private Long issueId;

    @Convert(converter = IssueTypeConverter.class)
    @Column(name = "issue_type", nullable = false)
    private IssueType issueType;

    @Column(name = "issue_info", nullable = false)
    private String issueInfo;

    @CreatedDate
    @Column(name = "create_datetime")
    private LocalDateTime createdAt;

}