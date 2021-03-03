package com.lyx.service;

import com.lyx.dto.EmployeeDto;
import com.lyx.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //保存用户信息
    void save(EmployeeDto employeeDto);

    //查找所有用户
    List<Employee> findAll();

    //根据id查询用户
    Employee findById(String id);

    //根据id删除用户
    void delete(String id);

    //更新用户信息(只能更新username,password,post,teamId)
    void update(EmployeeDto employeeDto);
}
