package com.lyx.dao;

import com.lyx.entity.BugTicketLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BugTicketLineDao {
    //创建缺陷清单备注
    Integer create(BugTicketLine bugTicketLine);

    //查找缺陷清单备注
    List<BugTicketLine> getBugTicketLine(String bugId);
}
