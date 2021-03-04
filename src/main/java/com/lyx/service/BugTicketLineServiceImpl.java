package com.lyx.service;

import com.lyx.dao.BugTicketLineDao;
import com.lyx.dao.EmployeeDao;
import com.lyx.dto.BugTicketLineDto;
import com.lyx.entity.BugTicketLine;
import com.lyx.entity.Employee;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BugTicketLineServiceImpl implements BugTicketLineService{
    @Autowired
    BugTicketLineDao bugTicketLineDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(BugTicketLineDto bugTicketLineDto) {
        String userId = bugTicketLineDto.getUserId();
        Employee employee = employeeDao.findById(userId);

        BugTicketLine bugTicketLine=new BugTicketLine();
        bugTicketLine.setBugLineId(IdGeneratorUtil.generateId());
        bugTicketLine.setBugId(bugTicketLineDto.getBugId());
        bugTicketLine.setNote(bugTicketLineDto.getNote());
        bugTicketLine.setAddId(userId);
        bugTicketLine.setAddName(employee.getRealName());
        bugTicketLine.setAddTime(new Date());

        bugTicketLineDao.save(bugTicketLine);
    }

    @Override
    public List<BugTicketLine> findAll() {
        return bugTicketLineDao.findAll();
    }

    @Override
    public void delete(String id) {
        bugTicketLineDao.delete(id);
    }

    @Override
    public void update(BugTicketLineDto bugTicketLineDto) {
        BugTicketLine bugTicketLine=new BugTicketLine();
        bugTicketLine.setBugLineId(bugTicketLineDto.getBugLineId());
        bugTicketLine.setNote(bugTicketLineDto.getNote());

        bugTicketLineDao.update(bugTicketLine);
    }
}
