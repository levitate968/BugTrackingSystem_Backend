package com.lyx.dao;

import com.lyx.entity.BugTicket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BugTicketDao {
    //保存缺陷追踪表
    void save(BugTicket bugTicket);

    //创建者保存缺陷追踪表
    void CreateSave(BugTicket bugTicket);

    //查询所有缺陷追踪表
    List<BugTicket> findAll();

    //根据id查找缺陷追踪表
    BugTicket findById(String id);

    //根据id删除缺陷追踪表
    void delete(String id);

    //更新缺陷追踪表
    void update(BugTicket bugTicket);
}
