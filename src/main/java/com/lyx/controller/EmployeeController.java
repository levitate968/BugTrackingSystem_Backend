package com.lyx.controller;

import com.lyx.dto.EmployeeDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.Employee;
import com.lyx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //根据(组名,姓名,id)条件查询员工
    @PostMapping("/findList")
    public ResponseDto<List<Employee>> findList(@RequestBody EmployeeQueryDto query) {
        return ResponseDto.getSuccessResponseDto(employeeService.findList(query));
        //return new ResponseDto<List<Employee>>("023","输入有误",employeeService.findList(query));
    }


}
