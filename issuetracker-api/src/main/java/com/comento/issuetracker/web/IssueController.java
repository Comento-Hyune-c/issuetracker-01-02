package com.comento.issuetracker.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {


    @RequestMapping("/issue/lists")
    public String issueList() {

        return "ok";
    }
}
