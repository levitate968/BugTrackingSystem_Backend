package com.lyx.dao;

import com.lyx.dto.EmployeeDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeDao {
    //保存用户
    Integer save(Employee employee);

    //查找所有用户
    List<Employee> findAll();

    //根据id查找用户
    Employee findById(String id);

    //根据id删除用户
    void delete(String id);

    //更新用户信息
    void update(Employee employee);

    //根据(组名,姓名,id)条件查询员工
    List<Employee> findList(EmployeeQueryDto queryDto);

    //修改密码
    void changePassword(Employee employee);

    //修改信息
    void changeInformation(EmployeeDto employeeDto);
}
