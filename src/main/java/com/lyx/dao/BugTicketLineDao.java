package com.lyx.dao;

import com.lyx.entity.BugTicketLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BugTicketLineDao {
    //保存
    void save(BugTicketLine bugTicketLine);

    //查找所有
    List<BugTicketLine> findAll();

    //根据id删除
    void delete(String id);

    //更新
    void update(BugTicketLine bugTicketLine);
}
