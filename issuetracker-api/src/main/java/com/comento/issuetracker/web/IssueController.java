package com.comento.issuetracker.web;

import com.comento.issuetracker.domain.issue.entity.Issue;
import com.comento.issuetracker.domain.issue.service.IssueService;
import com.comento.issuetracker.web.request.IssueCreateRequest;
import com.comento.issuetracker.web.response.IssueCreateResponse;
import com.comento.issuetracker.web.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "issue-controller")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issue")
public class IssueController {

    private final IssueService issueService;

    @Operation(summary = "create issue")
    @PostMapping
    public Response createIssue(@RequestBody @Valid IssueCreateRequest request) {
        Issue issue = Issue.builder()
            .issueTitle(request.getIssueTitle())
            .issueDesc(request.getIssueDesc())
            .build();

        Long issueId = issueService.createIssue(issue);

        return Response.builder()
            .code(HttpStatus.OK.value())
            .message(HttpStatus.OK.name())
            .data(IssueCreateResponse.builder().issueId(issueId).build())
            .build();
    }

}
