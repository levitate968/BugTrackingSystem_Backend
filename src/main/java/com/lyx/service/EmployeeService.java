package com.lyx.service;

import com.lyx.dto.EmployeeDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //保存员工信息
    void save(EmployeeDto employeeDto);

    //查找所有员工
    List<Employee> findAll();

    //根据id查询员工
    Employee findById(String id);

    //根据id删除员工
    void delete(String id);

    //更新员工信息(只能更新username,password,post,teamId)
    void update(EmployeeDto employeeDto);

    //根据(组名,姓名,id)条件查询员工
    List<Employee> findList(EmployeeQueryDto queryDto);
}
