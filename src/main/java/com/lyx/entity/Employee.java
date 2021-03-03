package com.lyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Employee {
    private String empId;
    private String username;
    private String password;
    private String realName;
    private String post;
    private String teamId;
}
