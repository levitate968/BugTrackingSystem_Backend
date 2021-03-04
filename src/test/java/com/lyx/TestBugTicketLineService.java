package com.lyx;

import com.lyx.dto.BugTicketLineDto;
import com.lyx.service.BugTicketLineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBugTicketLineService {
    @Autowired
    private BugTicketLineService bugTicketLineService;

    @Test
    public void testSave(){
        BugTicketLineDto bugTicketLineDto=new BugTicketLineDto();
        bugTicketLineDto.setBugId("78c8c07ade9843b4869f585517874f3f");
        bugTicketLineDto.setNote("test bug ticket line");
        bugTicketLineDto.setUserId("da6e5f94dd0244fda674018167ee4e7b");

        bugTicketLineService.save(bugTicketLineDto);
    }

    @Test
    public void testFindAll(){
        bugTicketLineService.findAll().forEach(bugTicketLine-> System.out.println("bugTicketLine = " + bugTicketLine));
    }

    @Test
    public void testDelete(){
        bugTicketLineService.delete("136d5bbd83ce4d11abad1391038b7c5b");
    }

    @Test
    public void testUpdate(){
        BugTicketLineDto bugTicketLineDto=new BugTicketLineDto();
        bugTicketLineDto.setBugLineId("436c2a02c8de4aa48aa123d62a7af502");
        bugTicketLineDto.setNote("test update bug ticket line");

        bugTicketLineService.update(bugTicketLineDto);
    }
}
