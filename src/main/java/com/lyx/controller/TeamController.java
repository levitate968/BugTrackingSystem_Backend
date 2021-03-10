package com.lyx.controller;

import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.dto.query.TeamQueryDto;
import com.lyx.entity.Employee;
import com.lyx.entity.Team;
import com.lyx.service.EmployeeService;
import com.lyx.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private EmployeeService employeeService;

    //根据(小组id，组名，员工id，员工姓名)条件查询小组
    @PostMapping("/findList")
    public ResponseDto<List<Team>> findList(@RequestBody TeamQueryDto query) {
        return ResponseDto.getSuccessResponseDto(teamService.findList(query));
    }
}
