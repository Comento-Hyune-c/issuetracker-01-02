package com.comento.issuetracker.domain.issueHistory.repository;

import com.comento.issuetracker.domain.issueHistory.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
