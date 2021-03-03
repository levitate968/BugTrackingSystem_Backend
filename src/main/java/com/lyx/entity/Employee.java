package com.lyx.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Employee {
    private String empId;
    private String username;
    private String password;
    private String realName;
    private String post;
    private String teamId;
}
