package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 * @author bizy
 * @date 2019/9/23 20:47
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
