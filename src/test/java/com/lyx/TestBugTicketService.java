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

    //private BugTicketService bugTicketService;
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveBugTicket(){
        BugTicketDto bugTicketDto=new BugTicketDto();
        bugTicketDto.setBugLevel("困难");
        bugTicketDto.setTeamId("1");
        bugTicketDto.setTitle("Test");
        bugTicketDto.setDescription("This is a test");
        bugTicketDto.setStatusCode("创建");
        bugTicketDto.setStatusName("");

        //bugTicketService.CreateSave(bugTicketDto);

    }

    @Test
    public void testSaveEmployee(){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setUsername("小轩子");
        employeeDto.setPassword("123456");
        employeeDto.setRealName("李禹轩");
        employeeDto.setPost("后端开发");
        employeeDto.setTeamId("1");

        employeeService.save(employeeDto);
    }
}
