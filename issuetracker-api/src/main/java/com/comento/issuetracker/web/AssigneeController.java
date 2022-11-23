package com.comento.issuetracker.web;

import com.comento.issuetracker.domain.issueAssignee.service.IssueAssigneeService;
import com.comento.issuetracker.web.request.IssueAssigneeRequest;
import com.comento.issuetracker.web.response.IssueAssigneeResponse;
import com.comento.issuetracker.web.response.Response;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignee")
@RequiredArgsConstructor
public class AssigneeController {

    private final IssueAssigneeService issueAssigneeService;

    @PostMapping
    public Response createIssueAssignee(@RequestBody @Valid IssueAssigneeRequest request) {
        Long issueAssigneeId = issueAssigneeService.createIssueAssignee(request);

        return Response.ok(IssueAssigneeResponse.builder().issueAssigneeId(issueAssigneeId).build());
    }


}
