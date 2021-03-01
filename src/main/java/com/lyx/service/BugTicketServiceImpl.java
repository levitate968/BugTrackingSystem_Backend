package com.lyx.service;

import com.lyx.dao.BugTicketDao;
import com.lyx.entity.BugTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BugTicketServiceImpl implements BugTicketService{
    @Autowired
    private BugTicketDao bugTicketDao;

    @Override
    public void save(BugTicket bugTicket) {
        bugTicketDao.save(bugTicket);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<BugTicket> findAll() {
        return bugTicketDao.findAll();
    }

    @Override
    public void delete(String bug_id) {
        bugTicketDao.delete(bug_id);
    }

    @Override
    public void update(BugTicket bugTicket) {
        bugTicketDao.update(bugTicket);
    }
}
