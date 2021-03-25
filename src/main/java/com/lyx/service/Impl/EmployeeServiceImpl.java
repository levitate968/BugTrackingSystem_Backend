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
import com.lyx.utils.CommonConstant;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseDto<String> createEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        employee.setEmpId(IdGeneratorUtil.generateId());
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(employeeDto.getPassword());
        employee.setRealName(employeeDto.getRealName());
        employee.setPost(employeeDto.getPost());
        employee.setTeamId(employeeDto.getTeamId());
        employee.setTeamName(employeeDto.getTeamName());

        //查询该用户名是否已经注册
        EmployeeQueryDto employeeQueryDto=new EmployeeQueryDto();
        employeeQueryDto.setUsername(employeeDto.getUsername());
        List<Employee> employeeList=employeeService.findList(employeeQueryDto);
        if(employeeList.isEmpty()){
            //如果这个用户名不存在
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

                String msg="创建用户成功";
                employeeDao.save(employee);
                return ResponseDto.getSuccessResponseDto(msg);
            }else {
                //如果存在这个组，创建者直接进组
                Team team=list.get(0);
                if(CommonConstant.TEAM_LEADER.equals(employee.getPost())){
                    if(team.getTeamLeaderId()==null){
                        //小组还没有小组组长
                        employee.setTeamId(team.getTeamId());
                        team.setTeamLeaderId(employee.getEmpId());
                        String msg="创建用户成功";
                        employeeDao.save(employee);
                        teamDao.update(team);
                        return ResponseDto.getSuccessResponseDto(msg);
                    }else{
                        //小组已经有小组组长
                        String msg="该小组已存在小组组长，请选择其他职位";
                        return ResponseDto.getFailResponseDto(msg);
                    }
                }else{
                    String msg="创建用户成功";
                    employeeDao.save(employee);
                    return ResponseDto.getSuccessResponseDto(msg);
                }
            }
        }else{
            //如果用户名已存在
            String msg="用户名已存在，请重新输入";
            return ResponseDto.getFailResponseDto(msg);
        }


    }

    @Override
    public ResponseDto<Map> login(EmployeeQueryDto employeeDto) {
        //登录逻辑函数
        String msg;
        Map<String,Object> map=new HashMap<>();
        try {
            List<Employee> list = employeeDao.findList(employeeDto);
            if (list.size() == 1) {
                msg = list.get(0).getUsername() + "登录成功，欢迎您!";
                map.put("msg",msg);
                map.put("employee",list.get(0));
                System.out.println(map.get("msg"));
                return ResponseDto.getSuccessResponseDto(map);
            } else {
                msg = "用户名或密码错误";
                map.put("msg",msg);
                return ResponseDto.getFailResponseDto(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
            return ResponseDto.getFailResponseDto(map);
        }
    }

}
