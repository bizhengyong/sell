package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 支付状态
 * @author bizy
 * @date 2019/9/24 19:46
 */
@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /*public static PayStatusEnum getPayStatusEnum(Integer code) {
        for (PayStatusEnum payStatusEnum : PayStatusEnum.values()) {
            if (payStatusEnum.getCode().equals(code)) {
                return payStatusEnum;
            }
        }
        return null;
    }*/
}
