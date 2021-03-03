package com.lyx;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.EmployeeDto;
import com.lyx.entity.BugTicket;
import com.lyx.service.BugTicketService;
import com.lyx.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBugTicketService {
    @Autowired
    private BugTicketService bugTicketService;

    @Test
    public void testSaveBugTicket(){
        BugTicketDto bugTicketDto=new BugTicketDto();
        bugTicketDto.setBugLevel("困难");
        bugTicketDto.setTeamId("1");
        bugTicketDto.setTitle("Test");
        bugTicketDto.setDescription("This is a test");
        bugTicketDto.setStatusCode("创建");
        bugTicketDto.setStatusName("");

        bugTicketService.CreateSave(bugTicketDto);

    }

}
