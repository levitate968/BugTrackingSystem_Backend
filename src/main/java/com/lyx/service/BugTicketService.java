package com.lyx.service;

import com.lyx.dto.BugTicketDto;
import com.lyx.dto.ResponseDto;
import com.lyx.dto.query.BugTicketQueryDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.Employee;

import java.util.List;

public interface BugTicketService {
    //创建者保存缺陷追踪表
    void submitSave(BugTicketDto bugTicketDto);

    //查询所有缺陷追踪表
    List<BugTicket> findAll();

    //根据id查找缺陷追踪表
    BugTicket findById(String id);

    //根据id删除缺陷追踪表
    void delete(String id);

    //更新缺陷追踪表(只能更新teamId,title,description,statusCode,statusName,bugLevel)
    void update(BugTicketDto bugTicketDto);

    //根据(题目，指派人，状态,小组id)条件查询缺陷追踪表
    List<BugTicket> findList(BugTicketQueryDto queryDto);

    //创建缺陷追踪表
    Integer createBugTicket(BugTicketDto bugTicketDto);

    //小组组长指派处理人处理缺陷追踪表
    ResponseDto<String> checkBugTicket (BugTicketDto bugTicketDto);

    //处理人完成对缺陷的修改
    Integer dealBugTicket(BugTicketDto bugTicketDto);

    //小组组长驳回提交人提交的处理缺陷追踪表
    Integer rejectBugTicket(BugTicketDto bugTicketDto);
}
