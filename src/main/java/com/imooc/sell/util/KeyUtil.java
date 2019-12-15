package com.imooc.sell.util;

import java.util.Random;

/**
 * @author bizy
 * @date 2019/9/24 21:51
 */
public class KeyUtil {

    /*
     * @description:生成唯一的主键 格式：时间+随机数
     * @param:
     * @author: bizy
     * @date: 2019/9/24 21:52
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
