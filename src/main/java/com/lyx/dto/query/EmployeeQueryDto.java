package com.lyx.dto.query;

import lombok.Data;

@Data
public class EmployeeQueryDto {
    private String empId;
    private String realName;
    private String teamName;
    private String username;
    private String password;
}
