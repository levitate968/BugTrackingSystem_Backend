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

    //修改密码
    @PostMapping("/changePassword")
    public ResponseDto<String> changePassword(@RequestBody EmployeeDto employeeDto){
        return employeeService.changePassword(employeeDto);
    }

    //修改个人信息
    @PostMapping("/changeInformation")
    public ResponseDto<String> changeInformation(@RequestBody EmployeeDto employeeDto){
        return employeeService.changeInformation(employeeDto);
    }

    //获取个人信息
    @GetMapping("/getInformation/{empId}")
    public ResponseDto<Employee> getInformation(@PathVariable String empId){
        return ResponseDto.getSuccessResponseDto(employeeService.getInformation(empId));
    }

    //获取待处理缺陷清单数量
    @GetMapping("/getDesignateCount/{empId}")
    public ResponseDto<Integer> getDesignateCount(@PathVariable String empId){
        return ResponseDto.getSuccessResponseDto(employeeService.getDesignateCount(empId));
    }
}
