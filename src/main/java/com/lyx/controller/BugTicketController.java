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

    //查询所有缺陷追踪表，并将待处理排在前面
    @PostMapping("/findListByOrder")
    public ResponseDto<List<BugTicket>> findListByOrder(@RequestBody BugTicketDto bugTicketDto) {
        return ResponseDto.getSuccessResponseDto(bugTicketService.findListByOrder(bugTicketDto));
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
    @PostMapping("/dealBugTicket")
    public ResponseDto<Integer> dealBugTicket(@RequestBody BugTicketDto bugTicketDto){
        return ResponseDto.getSuccessResponseDto(bugTicketService.dealBugTicket(bugTicketDto));
    }

    //小组组长驳回提交人提交的处理缺陷追踪表
    @PostMapping("/rejectBugTicket")
    public ResponseDto<Integer> rejectBugTicket(@RequestBody BugTicketDto bugTicketDto){
        return ResponseDto.getSuccessResponseDto(bugTicketService.rejectBugTicket(bugTicketDto));
    }

    //
}
