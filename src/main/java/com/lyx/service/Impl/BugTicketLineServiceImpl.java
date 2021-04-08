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
    public Integer dealBugTicket(String bugId, String note) {
        //获取缺陷清单
        BugTicketQueryDto bugTicketQueryDto=new BugTicketQueryDto();
        bugTicketQueryDto.setBugId(bugId);
        List<BugTicket> bugTickets=bugTicketDao.findList(bugTicketQueryDto);
        BugTicket bugTicket=bugTickets.get(0);

        //更新缺陷清单
        bugTicket.setStatusName(CommonConstant.DEALT);
        bugTicket.setDealTime(new Date());
        bugTicketDao.updateDealList(bugTicket);

        //获取添加人
        EmployeeQueryDto employeeQueryDto=new EmployeeQueryDto();
        employeeQueryDto.setEmpId(bugTicket.getDealId());
        List<Employee> employees=employeeDao.findList(employeeQueryDto);
        Employee employee=employees.get(0);

        //创建缺陷清单备注
        BugTicketLine bugTicketLine=new BugTicketLine();
        bugTicketLine.setBugLineId(IdGeneratorUtil.generateId());
        bugTicketLine.setBugId(bugTicket.getBugId());
        bugTicketLine.setNote(note);
        bugTicketLine.setAddId(employee.getEmpId());
        bugTicketLine.setAddName(employee.getRealName());
        bugTicketLine.setAddTime(new Date());

        return bugTicketLineDao.create(bugTicketLine);
    }
}
