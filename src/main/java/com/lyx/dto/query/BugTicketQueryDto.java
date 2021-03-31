package com.lyx.dto.query;

import lombok.Data;

@Data
public class BugTicketQueryDto {
    private String bugId;
    private String title;
    private String designateName;
    private String statusName;
    private String teamId;
}
