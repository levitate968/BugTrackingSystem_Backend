package com.lyx.controller;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.ResponseDto;
import com.lyx.entity.BugTicketLine;
import com.lyx.service.BugTicketLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("bugTicketLine")
public class BugTicketLineController {
    @Autowired
    private BugTicketLineService bugTicketLineService;

    @PostMapping("/getBugTicketLine")
    public ResponseDto<List<BugTicketLine>> getBugTicketLine(@RequestBody BugTicketDto bugTicketDto) {
        return ResponseDto.getSuccessResponseDto(bugTicketLineService.getBugTicketLine(bugTicketDto));
    }
}
