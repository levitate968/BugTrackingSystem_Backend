package com.lyx.dao;

import com.lyx.dto.query.BugTicketQueryDto;
import com.lyx.dto.query.EmployeeQueryDto;
import com.lyx.entity.BugTicket;
import com.lyx.entity.Employee;
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
    Integer submitSave(BugTicket bugTicket);

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

    /**
     *根据(题目，指派人，状态,小组id)条件查询缺陷追踪表
     * @param queryDto
     * @return
     */
    List<BugTicket> findList(BugTicketQueryDto queryDto);

    /**
     * 更新指派后的缺陷追踪表
     * @param bugTicket
     */
    void updateCheckList(BugTicket bugTicket);

    /**
     * 更新修改后的缺陷追踪表
     * @param bugTicket
     */
    void updateDealList(BugTicket bugTicket);
}
