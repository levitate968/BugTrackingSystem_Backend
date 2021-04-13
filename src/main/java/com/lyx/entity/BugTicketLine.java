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
public class BugTicketLine {
    private String bugLineId;
    private String bugId;
    private String note;
    private String addId;
    private String addName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
}
