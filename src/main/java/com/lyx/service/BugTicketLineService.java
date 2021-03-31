package com.lyx.service;

import com.lyx.dto.BugTicketLineDto;
import com.lyx.entity.BugTicketLine;

import java.util.List;

public interface BugTicketLineService {
    //保存
    void save(BugTicketLineDto bugTicketLineDto);

    //查询所有
    List<BugTicketLine> findAll();

    //根据id删除
    void delete(String id);

    //更新
    void update(BugTicketLineDto bugTicketLineDto);

    //

}
