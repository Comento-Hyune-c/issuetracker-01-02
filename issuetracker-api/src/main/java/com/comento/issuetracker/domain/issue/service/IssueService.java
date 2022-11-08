package com.comento.issuetracker.domain.issue.service;

import com.comento.issuetracker.domain.issue.entity.Issue;
import com.comento.issuetracker.domain.issue.repository.IssueRepository;
import com.comento.issuetracker.domain.issueHistory.constant.IssueType;
import com.comento.issuetracker.domain.issueHistory.entity.IssueHistory;
import com.comento.issuetracker.domain.issueHistory.repository.IssueHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueReposistory;
    private final IssueHistoryRepository issueHistoryRepository;

    public Long createIssue(Issue issue) {
        Long issueId = issueReposistory.save(issue).getIssueId();

        issueHistoryRepository.save(IssueHistory.builder()
                .issueId(issueId).issueType(IssueType.ISSUE)
                .issueInfo(issue.getIssueDesc()).build());
        return issueId;
    }

}