package com.comento.issuetracker.web;

import com.comento.issuetracker.domain.issue.entity.Issue;
import com.comento.issuetracker.domain.issue.service.IssueService;
import com.comento.issuetracker.web.request.CreateIssueRequest;
import com.comento.issuetracker.web.response.CreateIssueResponse;
import com.comento.issuetracker.web.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ErrorResponse> createIssue(@RequestBody @Valid CreateIssueRequest request) {
        Long issueId = issueService.createIssue(new Issue(request));

        return ResponseEntity.ok(new ErrorResponse(CreateIssueResponse.builder().issueId(issueId).build()));
    }

}
