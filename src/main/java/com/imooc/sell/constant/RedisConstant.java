package com.imooc.sell.constant;

/**
 * redis常量
 * @author bizy
 * @date 2019/12/31 21:00
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200;  //2小时
}
