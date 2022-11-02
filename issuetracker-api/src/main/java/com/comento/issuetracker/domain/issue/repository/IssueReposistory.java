package com.comento.issuetracker.domain.issue.repository;

import com.comento.issuetracker.domain.issue.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueReposistory extends JpaRepository<Issue, Long> {

}
