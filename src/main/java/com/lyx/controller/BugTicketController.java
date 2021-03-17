package com.lyx.controller;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.BugTicketQueryDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.Team;
import com.lyx.service.BugTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("bugTicket")
public class BugTicketController {
    @Autowired
    private BugTicketService bugTicketService;

    //根据(题目，指派人，状态,小组id)条件查询缺陷追踪表
    @PostMapping("/findList")
    public ResponseDto<List<BugTicket>> findList(@RequestBody BugTicketQueryDto query) {
        return ResponseDto.getSuccessResponseDto(bugTicketService.findList(query));
    }

    //创建缺陷追踪表
    @PostMapping("/createBugTicket")
    public ResponseDto<Integer> createBugTicket(@RequestBody BugTicketDto bugTicketDto){
        return ResponseDto.getSuccessResponseDto(bugTicketService.createBugTicket(bugTicketDto));
    }
}
