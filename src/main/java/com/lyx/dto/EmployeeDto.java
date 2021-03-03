package com.lyx.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String empId;
    private String username;
    private String password;
    private String realName;
    private String post;
    private String teamId;
}
