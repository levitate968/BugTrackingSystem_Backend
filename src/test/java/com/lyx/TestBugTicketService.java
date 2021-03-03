package com.lyx;

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
    public void testSave(){
        BugTicket bugTicket=new BugTicket();
        bugTicket.setBug_level("困难");
        bugTicket.setTeam_id("1");
        bugTicket.setTitle("");
        bugTicket.setDescription("");
        bugTicket.setStatus_code("");
        bugTicket.setStatus_name("");

    }
}
