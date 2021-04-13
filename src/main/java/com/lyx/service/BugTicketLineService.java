package com.lyx.service;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.BugTicketLineDto;
import com.lyx.entity.BugTicketLine;

import java.util.List;

public interface BugTicketLineService {
    //获取缺陷清单备注
    List<BugTicketLine> getBugTicketLine(BugTicketDto bugTicketDto);


}
