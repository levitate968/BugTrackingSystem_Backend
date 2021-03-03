package com.lyx.dao;

import com.lyx.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeDao {
    //保存用户
    void save(Employee employee);

    //查找所有用户
    List<Employee> findAll();

    //根据id查找用户
    Employee findById(String id);

    //根据id删除用户
    void delete(String id);

    //更新用户信息
    void update(Employee employee);
}
