create table issue
(
    issue_id    bigint        not null auto_increment,
    issue_title varchar(100)  not null,
    issue_desc  varchar(1000) not null,
    primary key (issue_id)
);

create table issue_history
(
    issue_history_id        bigint                                  not null auto_increment,
    issue_id                bigint                                  not null,
    issue_history_type      varchar(10)   default ''                not null,
    issue_history_info      varchar(1000) default ''                not null,
    create_datetime         datetime      default current_timestamp not null,
    primary key (issue_history_id)
);

create table user
(
    user_id bigint not null auto_increment,
    auth_id varchar(10) not null,
    auth_key varchar(100) not null,
    primary key (auth_id)
);

create table issue_assignee
(
    issue_assignee_id bigint not null auto_increment,
    issue_id bigint not null,
    user_id bigint not null,
    primary key (issue_id, user_id)
);
