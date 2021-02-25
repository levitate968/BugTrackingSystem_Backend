package com.lyx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class BugTicketLine {
    private String bug_line_id;
    private String bug_id;
    private String note;
    private String add_id;
    private String add_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date add_time;
}
