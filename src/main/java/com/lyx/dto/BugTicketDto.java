package com.lyx.dto;

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
