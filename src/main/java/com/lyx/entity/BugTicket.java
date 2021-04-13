package com.lyx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class BugTicket {
    private String bugId;
    private String teamId;
    private String title;
    private String description;
    private String statusCode;
    private String statusName;
    private String bugLevel;
    private String submitId;
    private String submitName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;
    private String checkId;
    private String checkName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;
    private String dealId;
    private String dealName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealTime;
    private String designateId;
    private String designateName;

}
