package com.lyx;

import com.lyx.dto.TeamDto;

import com.lyx.entity.Team;
import com.lyx.service.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTeamService {

    @Autowired
    private TeamService teamService;

    @Test
    public void testSave(){
        TeamDto teamDto=new TeamDto();
        teamDto.setName("java组");

        teamService.save(teamDto);
    }

    @Test
    public void testFindAll(){
        teamService.findAll().forEach(team-> System.out.println("team = " + team));
    }

    @Test
    public void testFindById(){
        Team team=teamService.findById("a8567ea3f252493e836b1535151f5268");
        System.out.println(team.toString());
    }

    @Test
    public void testDelete(){
        teamService.delete("2377556ae3cb4ac28c2393a9cea81e68");
    }

    @Test
    public void testUpdate(){
        TeamDto teamDto=new TeamDto();
        teamDto.setTeamId("a8567ea3f252493e836b1535151f5268");
        teamDto.setName("JAVA组");

        teamService.update(teamDto);
    }
}
