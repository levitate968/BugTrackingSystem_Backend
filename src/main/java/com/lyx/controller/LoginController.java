package com.lyx.controller;

import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("user")
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    //用户登录
    @PostMapping("/login")
    public ResponseDto<Map> login(@RequestBody EmployeeQueryDto employeeDto){
        return  employeeService.login(employeeDto);
    }

}
