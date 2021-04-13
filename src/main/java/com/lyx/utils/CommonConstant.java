package com.lyx.utils;

import java.util.concurrent.RejectedExecutionException;

public interface CommonConstant {
    //bug紧急程度
    String BUG_LEVEL_HINDER = "阻碍";
    String BUG_LEVEL_URGENCY = "紧急";
    String BUG_LEVEL_ORDINARY = "一般";

    //小组职位
    String TEAM_LEADER = "小组组长";
    String BACKEND_DEVELOPER = "后端开发";
    String FRONTEND_DEVELOPER = "前端开发";
    String TEST = "测试";

    //缺陷跟踪表的状态
    String SUBMITTED = "已提交";
    String CHECKED = "已审核";
    String DEALT = "已解决";
    String CLOSED = "已关闭";
    String REJECTED = "已驳回";


}
