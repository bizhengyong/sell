package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 支付状态
 * @author bizy
 * @date 2019/9/24 19:46
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
