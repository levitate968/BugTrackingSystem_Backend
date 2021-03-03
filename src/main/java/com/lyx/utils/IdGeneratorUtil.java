package com.lyx.utils;

import java.util.UUID;

public class IdGeneratorUtil {
    //生成随机id
    public static String generateId() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
