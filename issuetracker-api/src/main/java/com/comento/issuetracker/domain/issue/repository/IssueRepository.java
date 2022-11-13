package com.comento.issuetracker.domain.issue.repository;

import com.comento.issuetracker.domain.issue.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    //이슈 목록 조회
    public List<Issue> findByUseYnOrdeByRegAt(String useYn);


    // 이슈 제목으로 조회 -> 추후 조건 추가
    public List<Issue> findByIssueTitle(String issueTitle);

    //이슈 아이디로 조회
    public Issue findByissueId(Long issueId);
    //이슈 수정
    public void issueUpdate(Long issueId, IssueUpdateDto issueUpdateDto);
    //이슈 삭제
    public  void deleteByIssueId(Long issueId);
}
