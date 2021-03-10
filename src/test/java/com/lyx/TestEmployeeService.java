package com.lyx;

import com.lyx.dto.EmployeeDto;
import com.lyx.entity.Employee;
import com.lyx.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestEmployeeService {

    @Autowired
    private EmployeeService employeeService;



    @Test
    public void testFindAll(){
        employeeService.findAll().forEach(employee-> System.out.println("employee = " + employee));
    }

    @Test
    public void testFindById(){
        Employee employee=employeeService.findById("da6e5f94dd0244fda674018167ee4e7b");
        System.out.println(employee.toString());
    }

    @Test
    public void testDelete(){
        employeeService.delete("da6e5f94dd0244fda674018167ee4e7b");
    }

    @Test
    public void testUpdate(){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setEmpId("9e384a11584d44e6bf7c5a53a4feb911");
        employeeDto.setUsername("小轩子");
        employeeDto.setPassword("990122");
        employeeDto.setPost("小组组长");
        employeeDto.setTeamId("a8567ea3f252493e836b1535151f5268");

        employeeService.update(employeeDto);
    }
}
