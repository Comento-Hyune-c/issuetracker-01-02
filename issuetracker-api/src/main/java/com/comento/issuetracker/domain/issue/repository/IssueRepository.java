package com.comento.issuetracker.domain.issue.repository;

import com.comento.issuetracker.domain.issue.entity.Issue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IssueRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Issue> findAll() {
        return em.createQuery("select i from Issue i", Issue.class)
                .getResultList();
    }
}
