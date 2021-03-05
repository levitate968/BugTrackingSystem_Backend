package com.lyx.service;

import com.lyx.dao.EmployeeDao;
import com.lyx.dto.EmployeeDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.Employee;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmpId(IdGeneratorUtil.generateId());
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(employeeDto.getPassword());
        employee.setRealName(employeeDto.getRealName());
        employee.setPost(employeeDto.getPost());
        employee.setTeamId(employeeDto.getTeamId());

        employeeDao.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeDao.findById(id);
    }

    @Override
    public void delete(String id) {
        employeeDao.delete(id);
    }

    @Override
    public void update(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmpId(employeeDto.getEmpId());
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(employeeDto.getPassword());
        employee.setPost(employeeDto.getPost());
        employee.setTeamId(employeeDto.getTeamId());

        employeeDao.update(employee);
    }

    @Override
    public List<Employee> findList(EmployeeQueryDto queryDto) {
        List<Employee> list = employeeDao.findList(queryDto);
        return list;
    }


}
