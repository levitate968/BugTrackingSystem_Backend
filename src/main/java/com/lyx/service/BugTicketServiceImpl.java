package com.lyx.service;

import com.lyx.dao.BugTicketDao;
import com.lyx.dao.EmployeeDao;
import com.lyx.dto.BugTicketDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.Employee;
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
public class BugTicketServiceImpl implements BugTicketService{
    @Autowired
    private BugTicketDao bugTicketDao;
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void CreateSave(BugTicketDto bugTicketDto) {
        String userId = bugTicketDto.getUserId();
        Employee employee = employeeDao.findById(userId);

        BugTicket bugTicket = new BugTicket();
        bugTicket.setBugId(IdGeneratorUtil.generateId());
        bugTicket.setTeamId(bugTicketDto.getTeamId());
        bugTicket.setTitle(bugTicket.getTitle());
        bugTicket.setDescription(bugTicket.getDescription());
        bugTicket.setStatusCode(bugTicket.getStatusCode());
        //TODO 从静态文件中对照StatusCode获取StatusName
        bugTicket.setBugLevel(bugTicket.getBugLevel());
        bugTicket.setCreateId(bugTicketDto.getUserId());
        bugTicket.setCreateName(employee.getRealName());
        bugTicket.setCreateTime(new Date());

        bugTicketDao.save(bugTicket);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<BugTicket> findAll() {
        return bugTicketDao.findAll();
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
        bugTicket.setTitle(bugTicket.getTitle());
        bugTicket.setDescription(bugTicket.getDescription());
        bugTicket.setStatusCode(bugTicket.getStatusCode());
        //TODO 从静态文件中对照StatusCode获取StatusName
        bugTicket.setBugLevel(bugTicket.getBugLevel());

        bugTicketDao.update(bugTicket);
    }
}
