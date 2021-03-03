package com.lyx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class BugTicketLine {
    private String bugLineId;
    private String bugId;
    private String note;
    private String addId;
    private String addName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addTime;
}
