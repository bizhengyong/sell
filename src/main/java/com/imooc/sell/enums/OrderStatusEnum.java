package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 订单状态
 * @author bizy
 * @date 2019/9/24 19:42
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /*public static OrderStatusEnum getOrderStatusEnum(Integer code){
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum;
            }
        }
        return null;
    }*/

}
