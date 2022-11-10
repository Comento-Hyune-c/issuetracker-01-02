package com.comento.issuetracker.domain.issueHistory.entity;

import com.comento.issuetracker.domain.issueHistory.constant.IssueHistoryType;
import com.comento.issuetracker.domain.issueHistory.converter.IssueHistoryTypeConverter;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "issue_history")
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
public class IssueHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_history_id")
    private Long issueHistoryId;

    @Column(name = "issue_id")
    private Long issueId;

    @Convert(converter = IssueHistoryTypeConverter.class)
    @Column(name = "issue_history_type", nullable = false)
    private IssueHistoryType issueHistoryType;

    @Column(name = "issue_history_info", nullable = false)
    private String issueHistoryInfo;

    @CreatedDate
    @Column(name = "create_datetime")
    private LocalDateTime createdAt;

    public static IssueHistory of(Long issueId, IssueHistoryType issueHistoryType, String issueHistoryInfo) {
        IssueHistory issueHistory = new IssueHistory();
        issueHistory.setIssueId(issueId);
        issueHistory.setIssueHistoryType(issueHistoryType);
        issueHistory.setIssueHistoryInfo(issueHistoryInfo);

        return issueHistory;
    }

}
