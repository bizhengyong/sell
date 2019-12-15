package com.imooc.sell.dto;

import lombok.Data;

/**
 * 购物车
 * @author bizy
 * @date 2019/10/10 19:30
 */
@Data
public class CartDTO {

    /** 商品ID **/
    private String productId;

    /** 数量 **/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
