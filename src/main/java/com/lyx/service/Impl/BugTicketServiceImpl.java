package com.lyx.service.Impl;

import com.lyx.dao.BugTicketDao;
import com.lyx.dao.EmployeeDao;
import com.lyx.dto.BugTicketDto;
import com.lyx.dto.query.BugTicketQueryDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.Employee;
import com.lyx.service.BugTicketService;
import com.lyx.utils.IdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BugTicketServiceImpl implements BugTicketService {
    @Autowired
    private BugTicketDao bugTicketDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void submitSave(BugTicketDto bugTicketDto) {
        String userId = bugTicketDto.getUserId();
        Employee employee = employeeDao.findById(userId);

        BugTicket bugTicket = new BugTicket();
        bugTicket.setBugId(IdGeneratorUtil.generateId());
        bugTicket.setTeamId(bugTicketDto.getTeamId());
        bugTicket.setTitle(bugTicketDto.getTitle());
        bugTicket.setDescription(bugTicketDto.getDescription());
        bugTicket.setStatusCode(bugTicketDto.getStatusCode());
        //TODO 从静态文件中对照StatusCode获取StatusName
        bugTicket.setBugLevel(bugTicketDto.getBugLevel());
        bugTicket.setSubmitId(employee.getEmpId());
        bugTicket.setSubmitName(employee.getRealName());
        bugTicket.setSubmitTime(new Date());

        bugTicketDao.submitSave(bugTicket);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<BugTicket> findAll() {
        return bugTicketDao.findAll();
    }

    @Override
    public BugTicket findById(String id) {
        return bugTicketDao.findById(id);
    }

    @Override
    public void delete(String id) {
        bugTicketDao.delete(id);
    }

    @Override
    public void update(BugTicketDto bugTicketDto) {
        BugTicket bugTicket = new BugTicket();
        bugTicket.setBugId(bugTicketDto.getBugId());
        bugTicket.setTeamId(bugTicketDto.getTeamId());
        bugTicket.setTitle(bugTicketDto.getTitle());
        bugTicket.setDescription(bugTicketDto.getDescription());
        bugTicket.setStatusCode(bugTicketDto.getStatusCode());
        //TODO 从静态文件中对照StatusCode获取StatusName
        bugTicket.setBugLevel(bugTicketDto.getBugLevel());

        bugTicketDao.update(bugTicket);
    }

    @Override
    public List<BugTicket> findList(BugTicketQueryDto queryDto) {
        List<BugTicket> list = bugTicketDao.findList(queryDto);
        return list;
    }

    @Override
    @Transactional
    public Integer createBugTicket(BugTicketDto bugTicketDto) {
        //TODO
        BugTicket bugTicket = new BugTicket();
        //bugTicketDao.createBugTicket(bugTicket);
        return bugTicketDao.submitSave(bugTicket);
    }
}
