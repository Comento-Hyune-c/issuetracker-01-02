package com.comento.issuetracker.domain.issue.service;

import com.comento.issuetracker.domain.issue.entity.Issue;
import com.comento.issuetracker.domain.issue.repository.IssueRepository;
import com.comento.issuetracker.domain.issue.repository.IssueUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueReposistory;

    public Long createIssue(Issue issue) {
        return issueReposistory.save(issue).getIssueId();
    }

    //이슈 open ,close 에 따라 조회
    public List<Issue> findByUseYnOrdeByRegAt(String useYn) {
        if(useYn.equals("Y")){
            return issueReposistory.findByUseYnOrdeByRegAt("Y");
        } else {
            return issueReposistory.findByUseYnOrdeByRegAt("N");
        }
    };

    //이슈 제목으로 모두 조회
    public List<Issue> findByIssueTitleLike(String issueTitle) {
        return issueReposistory.findByIssueTitleLike(issueTitle);
    }

    // 이슈 아이디로 조회
    public Issue findByIssueId(Long issueId) {
        return issueReposistory.findByissueId(issueId);
    }
    //이슈 수정
    public void issueUpdate(Long issueId, IssueUpdateDto issueUpdateDto) {
        Issue updateIssue = issueReposistory.findByissueId(issueId);
        updateIssue.setIssueTitle(issueUpdateDto.getIssueTitle());
    }

    //이슈 삭제
    public void deleteByissueId(Long issueId) {
        issueReposistory.deleteByIssueId(issueId);
    }
}