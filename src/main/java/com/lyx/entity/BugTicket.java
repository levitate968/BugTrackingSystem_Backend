package com.lyx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class BugTicket {
    private String bugId;
    private String teamId;
    private String title;
    private String description;
    private String statusCode;
    private String statusName;
    private String bugLevel;
    private String createId;
    private String createName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String submitId;
    private String submitName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitTime;
    private String checkId;
    private String checkName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkTime;
    private String dealId;
    private String dealName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dealTime;
    private String testId;
    private String testName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date testTime;

}
