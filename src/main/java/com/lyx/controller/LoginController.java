package com.lyx.controller;

import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("user")
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    //用户登录
    @PostMapping("/login")
    public ResponseDto<String> login(@RequestBody EmployeeQueryDto employeeDto, HttpServletRequest request){
        return  employeeService.login(employeeDto,request);
    }

    //获取用户登录信息
//    @GetMapping("/info")
//    public ResponseDto<Map> info(){
//        return ResponseDto.getSuccessResponseDto();
//    }
}
