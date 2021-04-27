package com.lyx.service;

import com.lyx.dto.EmployeeDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
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

    //新建用户
    ResponseDto<String> createEmployee(EmployeeDto employeeDto);

    //用户登录
    ResponseDto<Map> login(EmployeeQueryDto employeeDto);

    //修改密码
    ResponseDto<String> changePassword(EmployeeDto employeeDto);

    //修改个人信息
    ResponseDto<String> changeInformation(EmployeeDto employeeDto);

    //获取个人信息
    Employee getInformation(String empId);

    //获取待处理缺陷清单数量
    Integer getDesignateCount(String empId);
}
