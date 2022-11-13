package com.comento.issuetracker.web;

import com.comento.issuetracker.domain.issue.entity.Issue;
import com.comento.issuetracker.domain.issue.repository.IssueUpdateDto;
import com.comento.issuetracker.domain.issue.service.IssueService;
import com.comento.issuetracker.web.request.IssueCreateRequest;
import com.comento.issuetracker.web.response.IssueCreateResponse;
import com.comento.issuetracker.web.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //이슈 open ,close 에 따라 조회
    @GetMapping
    public List<Issue> findByUseYnOrdeByRegAt (String useYn) {
        return issueService.findByUseYnOrdeByRegAt(useYn);
    }

    //이슈 제목으로 조회  -> 추후 filter 기능 추가(동적쿼리로...)
    @GetMapping
    public List<Issue> findByIssueTitle(String issueTitle) {
        return issueService.findByIssueTitleLike(issueTitle);
    }

    //이슈 수정

    public void issueUpdate(Long issueId, IssueUpdateDto issueUpdateDto){
        issueService.issueUpdate(issueId, issueUpdateDto);
    }

    //이슈 삭제
    public void deleteByIssueId(Long issueId) {
        issueService.deleteByissueId(issueId);
    }

}
