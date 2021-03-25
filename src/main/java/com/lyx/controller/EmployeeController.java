package com.lyx.controller;

import com.lyx.dto.EmployeeDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.Employee;
import com.lyx.service.EmployeeService;
import com.lyx.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TeamService teamService;

    //根据(组名,姓名,id)条件查询员工
    @PostMapping("/findList")
    public ResponseDto<List<Employee>> findList(@RequestBody EmployeeQueryDto query, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        //System.out.println(query.toString());
        return ResponseDto.getSuccessResponseDto(employeeService.findList(query));
    }

    //注册用户(输入用户名,真实姓名,密码,组名,职位)
    @PostMapping("/createEmployee")
    public ResponseDto<String> createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }




}
