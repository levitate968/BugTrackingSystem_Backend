package com.lyx.utils;

import java.util.HashMap;
import java.util.Map;

public interface CommonConstant {
    //bug紧急程度
    String BUG_LEVEL_HINDER = "阻碍";
    String BUG_LEVEL_URGENCY = "紧急";
    String BUG_LEVEL_ORDINARY = "一般";

    //缺陷跟踪表的状态码
    String SUBMITTED = "submitted";
    String CHECKED = "checked";
    String DEALT = "dealt";
    String CLOSED = "closed";

    default Map<String, String> getStatusMap() {
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put(CommonConstant.SUBMITTED, "已提交");
        statusMap.put(CommonConstant.CHECKED, "已审核");
        statusMap.put(CommonConstant.DEALT, "已解决");
        statusMap.put(CommonConstant.CLOSED, "已关闭");
        return statusMap;
    }
}
