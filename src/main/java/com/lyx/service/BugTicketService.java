package com.lyx.service;

import com.lyx.dto.BugTicketDto;
import com.lyx.entity.BugTicket;

import java.util.List;

public interface BugTicketService {
    //创建者保存缺陷追踪表
    void CreateSave(BugTicketDto bugTicketDto);

    //查询所有缺陷追踪表
    List<BugTicket> findAll();

    //根据id删除缺陷追踪表
    void delete(String id);

    //更新缺陷追踪表(只能更新teamId,title,description,statusCode,statusName,bugLevel)
    void update(BugTicketDto bugTicketDto);

}
