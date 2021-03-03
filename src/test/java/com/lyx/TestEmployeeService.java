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
    public void testSave(){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setUsername("小轩子");
        employeeDto.setPassword("123456");
        employeeDto.setRealName("李禹轩");
        employeeDto.setPost("后端开发");
        employeeDto.setTeamId("1");

        employeeService.save(employeeDto);
    }

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
        employeeService.delete("a88a807b3101465eae6629669fd30a4f");
    }
}
