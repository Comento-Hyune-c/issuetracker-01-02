create table issue
(
    issue_id    bigint        not null auto_increment,
    issue_title varchar(100)  not null,
    issue_desc  varchar(1000) not null,
    primary key (issue_id)
);
