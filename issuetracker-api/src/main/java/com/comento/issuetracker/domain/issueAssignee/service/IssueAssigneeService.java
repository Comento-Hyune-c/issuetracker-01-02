package com.comento.issuetracker.domain.issueAssignee.service;

import com.comento.issuetracker.domain.issueAssignee.entity.IssueAssignee;
import com.comento.issuetracker.domain.issueAssignee.repository.IssueAssigneeRepository;
import com.comento.issuetracker.web.request.IssueAssigneeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IssueAssigneeService {

    private final IssueAssigneeRepository issueAssigneeRepository;

    @Transactional
    public Long createIssueAssignee(IssueAssigneeRequest request) {
        IssueAssignee issueAssignee = IssueAssignee.ofRequest(request.getIssueId(), request.getUserId());

        return issueAssigneeRepository.save(issueAssignee).getIssueAssigneeId();
    }

}
