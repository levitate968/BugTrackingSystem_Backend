package com.lyx;

import com.lyx.dto.EmployeeDto;
import com.lyx.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestEmployeeService {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveEmployee(){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setUsername("小轩子");
        employeeDto.setPassword("123456");
        employeeDto.setRealName("李禹轩");
        employeeDto.setPost("后端开发");
        employeeDto.setTeamId("1");

        employeeService.save(employeeDto);
    }
}
