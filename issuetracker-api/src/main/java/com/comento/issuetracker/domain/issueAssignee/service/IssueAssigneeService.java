package com.comento.issuetracker.domain.issueAssignee.service;

import com.comento.issuetracker.domain.issueAssignee.entity.IssueAssignee;
import com.comento.issuetracker.domain.issueAssignee.repository.IssueAssigneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IssueAssigneeService {

    private final IssueAssigneeRepository issueAssigneeRepository;

    @Transactional
    public Long createIssueAssignee(IssueAssignee issueAssignee) {

        return issueAssigneeRepository.save(issueAssignee).getIssueAssigneeId();
    }

}
