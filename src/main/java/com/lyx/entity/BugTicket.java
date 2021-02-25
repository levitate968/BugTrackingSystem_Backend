package com.lyx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BugTicket {
    private String bug_id;
    private String team_id;
    private String title;
    private String description;
    private String status_code;
    private String status_name;
    private String bug_level;
    private String create_id;
    private String create_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    private String submit_id;
    private String submit_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submit_time;
    private String check_id;
    private String check_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date check_time;
    private String deal_id;
    private String deal_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deal_time;
    private String test_id;
    private String test_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date test_time;

}
