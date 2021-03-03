package com.lyx;

import com.lyx.dto.BugTicketDto;
import com.lyx.entity.BugTicket;
import com.lyx.service.BugTicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBugTicketService {
    @Autowired
    private BugTicketService bugTicketService;

    @Test
    public void testCreateSave(){
        BugTicketDto bugTicketDto=new BugTicketDto();
        bugTicketDto.setTeamId("1");
        bugTicketDto.setTitle("Test");
        bugTicketDto.setDescription("This is a test");
        bugTicketDto.setStatusCode("create");
        bugTicketDto.setStatusName("创建");
        bugTicketDto.setBugLevel("困难");
        bugTicketDto.setUserId("da6e5f94dd0244fda674018167ee4e7b");

        bugTicketService.CreateSave(bugTicketDto);
    }

    @Test
    public void testFindAll(){
        bugTicketService.findAll().forEach(bugTicket-> System.out.println("bugTicket = " + bugTicket));
    }

    @Test
    public void testFindById(){
        BugTicket bugTicket=bugTicketService.findById("78c8c07ade9843b4869f585517874f3f");
        System.out.println(bugTicket.toString());
    }

    @Test
    public void testDelete(){
        bugTicketService.delete("091a20fefbf742a683505d188fa73952");
    }

    @Test
    public void testUpdate(){
        BugTicketDto bugTicketDto=new BugTicketDto();
        bugTicketDto.setBugId("aa7f2aa3534e4e9a9af0e2bb4efa1e9f");
        bugTicketDto.setTeamId("2");
        bugTicketDto.setTitle("update");
        bugTicketDto.setDescription("this is an update test");
        bugTicketDto.setStatusCode("change");
        bugTicketDto.setStatusName("修改");
        bugTicketDto.setBugLevel("简单");

        bugTicketService.update(bugTicketDto);
    }
}
