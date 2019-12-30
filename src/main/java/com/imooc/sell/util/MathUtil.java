package com.imooc.sell.util;

/**
 * @author bizy
 * @date 2019/12/23 20:47
 */
public class MathUtil {
    public static final Double MONEY_RANGE = 0.01;

    /*
     * @description:比较2个金额是否相等
     * @param:
     * @author: bizy
     * @date: 2019/12/23 20:49
     */
    public static Boolean equals(Double d1,Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
