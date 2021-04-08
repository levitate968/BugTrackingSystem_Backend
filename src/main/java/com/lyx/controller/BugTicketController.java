package com.lyx.controller;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.BugTicketQueryDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.Team;
import com.lyx.service.BugTicketLineService;
import com.lyx.service.BugTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("bugTicket")
public class BugTicketController {
    @Autowired
    private BugTicketService bugTicketService;
    @Autowired
    private BugTicketLineService bugTicketLineService;

    //根据(题目，指派人，状态,小组id)条件查询缺陷追踪表
    @PostMapping("/findList")
    public ResponseDto<List<BugTicket>> findList(@RequestBody BugTicketQueryDto query, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        //System.out.println(bugTicketService.findList(query).toString());
        return ResponseDto.getSuccessResponseDto(bugTicketService.findList(query));
    }


    //提出者创建缺陷追踪表
    @PostMapping("/createBugTicket")
    public ResponseDto<Integer> createBugTicket(@RequestBody BugTicketDto bugTicketDto){
        //System.out.println(bugTicketDto.toString());
        return ResponseDto.getSuccessResponseDto(bugTicketService.createBugTicket(bugTicketDto));
    }

    //小组组长指派处理人处理缺陷追踪表
    @PostMapping("/checkBugTicket")
    public ResponseDto<String> checkBugTicket(@RequestBody BugTicketDto bugTicketDto){
        return  bugTicketService.checkBugTicket(bugTicketDto);
    }

    //处理人完成对缺陷的修改
    @GetMapping("/dealBugTicket")
    public ResponseDto<Integer> dealBugTicket(@RequestParam String bugId,@RequestParam String note){
        return ResponseDto.getSuccessResponseDto(bugTicketLineService.dealBugTicket(bugId,note));
    }
}
