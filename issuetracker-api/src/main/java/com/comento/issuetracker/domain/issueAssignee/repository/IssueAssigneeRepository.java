package com.comento.issuetracker.domain.issueAssignee.repository;

import com.comento.issuetracker.domain.issueAssignee.entity.IssueAssignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueAssigneeRepository extends JpaRepository<IssueAssignee, Long> {

}
