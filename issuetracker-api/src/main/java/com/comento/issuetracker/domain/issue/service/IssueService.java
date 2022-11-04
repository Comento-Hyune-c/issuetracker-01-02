package com.comento.issuetracker.domain.issue.service;

import com.comento.issuetracker.domain.issue.entity.Issue;
import com.comento.issuetracker.domain.issue.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueReposistory;

    public Long createIssue(Issue issue) {
        return issueReposistory.save(issue).getIssueId();
    }

}