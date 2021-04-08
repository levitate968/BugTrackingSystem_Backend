package com.lyx.service;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.BugTicketLineDto;
import com.lyx.entity.BugTicketLine;

import java.util.List;

public interface BugTicketLineService {
    //处理人完成对缺陷的修改
    Integer dealBugTicket(String bugId, String note);

}
