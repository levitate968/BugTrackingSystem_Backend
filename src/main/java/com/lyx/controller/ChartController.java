package com.lyx.controller;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.chart.EmployeeChartDto;
import com.lyx.dto.chart.StatusChartDto;
import com.lyx.service.BugTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("chart")
public class ChartController {
    @Autowired
    private BugTicketService bugTicketService;

    //获取状态图表的数据
    @PostMapping("/getStatusChart")
    public ResponseDto<List<StatusChartDto>> getStatusChart(@RequestBody BugTicketDto bugTicketDto){
        return ResponseDto.getSuccessResponseDto(bugTicketService.getStatusChart(bugTicketDto));
    }

    //获取状态图表的数据
    @PostMapping("/getEmployeeChart")
    public ResponseDto<EmployeeChartDto> getEmployeeChart(@RequestBody BugTicketDto bugTicketDto){
        return ResponseDto.getSuccessResponseDto(bugTicketService.getEmployeeChart(bugTicketDto));
    }
}
