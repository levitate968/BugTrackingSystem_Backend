package com.lyx.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BugTicketDto {
    private String bugId;
    private String teamId;
    private String title;
    private String description;
    private String statusCode;
    private String statusName;
    private String bugLevel;
    private String userId;
}
