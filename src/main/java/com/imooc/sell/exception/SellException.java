package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * @author bizy
 * @date 2019/9/24 21:34
 */
public class SellException extends  RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
