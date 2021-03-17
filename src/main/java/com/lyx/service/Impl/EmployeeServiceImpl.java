package com.lyx.service.Impl;

import com.lyx.dao.EmployeeDao;
import com.lyx.dao.TeamDao;
import com.lyx.dto.EmployeeDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.TeamDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.dto.query.TeamQueryDto;
import com.lyx.entity.Employee;
import com.lyx.entity.Team;
import com.lyx.service.EmployeeService;
import com.lyx.service.TeamService;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private EmployeeService employeeService;


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

    @Override
    public Integer createEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setEmpId(IdGeneratorUtil.generateId());
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(employeeDto.getPassword());
        employee.setRealName(employeeDto.getRealName());
        employee.setPost(employeeDto.getPost());
        employee.setTeamId(employeeDto.getTeamId());

        //获取该组名所在的组
        String teamName=employeeDto.getTeamName();
        TeamQueryDto teamQueryDto=new TeamQueryDto();
        teamQueryDto.setTeamName(teamName);
        List<Team> list=teamService.findList(teamQueryDto);

        if (list.isEmpty()) {
            //如果不存在这个组，创建该组，并且组长就是创建人
            TeamDto teamDto=new TeamDto();
            teamDto.setTeamName(teamName);
            teamDto.setTeamLeaderId(employee.getEmpId());
            teamDto.setTeamId(IdGeneratorUtil.generateId());
            employee.setPost("小组组长");
            employee.setTeamId(teamDto.getTeamId());
            teamService.save(teamDto);

        }else {
            //如果存在这个组，创建者直接进组
            Team team=list.get(0);
            employee.setTeamId(team.getTeamId());
        }

        return employeeDao.save(employee);
    }

    @Override
    public ResponseDto<String> login(EmployeeQueryDto employeeDto) {
        //登录逻辑函数
        String msg;
        try {
            List<Employee> list = employeeDao.findList(employeeDto);
            if (list.size() == 1) {
                msg = list.get(0).getUsername() + "登录成功，欢迎您!";
                return ResponseDto.getSuccessResponseDto(msg);
            } else {
                msg = "用户名或密码错误";
                return ResponseDto.getFailResponseDto(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.getFailResponseDto(e.getMessage());
        }
    }

}
