package com.lyx.service;

import com.lyx.dao.TeamDao;
import com.lyx.dto.TeamDto;
import com.lyx.entity.Team;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamDao teamDao;

    @Override
    public void save(TeamDto teamDto) {
        Team team=new Team();
        team.setTeamId(IdGeneratorUtil.generateId());
        team.setName(teamDto.getName());

        teamDao.save(team);
    }

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public Team findById(String id) {
        return teamDao.findById(id);
    }

    @Override
    public void delete(String id) {
        teamDao.delete(id);
    }

    @Override
    public void update(TeamDto teamDto) {
        Team team=new Team();
        team.setTeamId(teamDto.getTeamId());
        team.setName(teamDto.getName());

        teamDao.update(team);
    }
}
