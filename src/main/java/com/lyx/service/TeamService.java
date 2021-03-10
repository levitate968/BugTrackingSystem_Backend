package com.lyx.service;

import com.lyx.dto.TeamDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.dto.query.TeamQueryDto;
import com.lyx.entity.Employee;
import com.lyx.entity.Team;

import java.util.List;

public interface TeamService {
    //创建小组
    void save(TeamDto teamDto);

    //查找所有小组
    List<Team> findAll();

    //根据id查找小组
    Team findById(String id);

    //根据id删除小组
    void delete(String id);

    //更新小组信息
    void update(TeamDto teamDto);

    //根据(小组id，组名，员工id，员工姓名)条件查询小组
    List<Team> findList(TeamQueryDto queryDto);
}
