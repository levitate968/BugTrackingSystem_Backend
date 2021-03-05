package com.lyx.dao;

import com.lyx.entity.BugTicket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BugTicketDao {

    /**
     * 保存缺陷追踪表
     * @param bugTicket
     */
    void save(BugTicket bugTicket);

    /**
     * 创建者保存缺陷追踪表
     * @param bugTicket
     */
    void CreateSave(BugTicket bugTicket);

    /**
     * 查询所有缺陷追踪表
     * @return
     */
    List<BugTicket> findAll();

    /**
     * 根据id查找缺陷追踪表
     * @param id
     * @return
     */
    BugTicket findById(String id);

    /**
     * 根据id删除缺陷追踪表
     * @param id
     */
    void delete(String id);

    /**
     * 更新缺陷追踪表
     * @param bugTicket
     */
    void update(BugTicket bugTicket);
}
