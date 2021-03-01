package com.lyx.service;

import com.lyx.entity.BugTicket;

import java.util.List;

public interface BugTicketService {
    //保存缺陷追踪表
    void save(BugTicket bugTicket);

    //查询所有缺陷追踪表
    List<BugTicket> findAll();

    //根据id删除缺陷追踪表
    void delete(String bug_id);

    //更新缺陷追踪表
    void update(BugTicket bugTicket);

}
