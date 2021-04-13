package com.lyx.service.Impl;

import com.lyx.dao.BugTicketDao;
import com.lyx.dao.BugTicketLineDao;
import com.lyx.dao.EmployeeDao;
import com.lyx.dto.BugTicketDto;
import com.lyx.dto.BugTicketLineDto;
import com.lyx.dto.query.BugTicketQueryDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.BugTicketLine;
import com.lyx.entity.Employee;
import com.lyx.service.BugTicketLineService;
import com.lyx.utils.CommonConstant;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BugTicketLineServiceImpl implements BugTicketLineService {
    @Autowired
    BugTicketLineDao bugTicketLineDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private BugTicketDao bugTicketDao;


    @Override
    public List<BugTicketLine> getBugTicketLine(BugTicketDto bugTicketDto) {
        String bugId=bugTicketDto.getBugId();
        return bugTicketLineDao.getBugTicketLine(bugId);
    }
}
