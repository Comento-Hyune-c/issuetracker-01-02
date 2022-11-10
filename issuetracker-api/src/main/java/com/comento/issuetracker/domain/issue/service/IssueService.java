package com.comento.issuetracker.domain.issue.service;

import com.comento.issuetracker.domain.issue.entity.Issue;
import com.comento.issuetracker.domain.issue.repository.IssueRepository;
import com.comento.issuetracker.domain.issueHistory.constant.IssueHistoryType;
import com.comento.issuetracker.domain.issueHistory.entity.IssueHistory;
import com.comento.issuetracker.domain.issueHistory.repository.IssueHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;
    private final IssueHistoryRepository issueHistoryRepository;

    @Transactional
    public Long createIssue(Issue issue) {
        Long issueId = issueRepository.save(issue).getIssueId();

        issueHistoryRepository.save(IssueHistory.of(issueId, IssueHistoryType.ISSUE, issue.getIssueDesc()));
        return issueId;
    }

}
