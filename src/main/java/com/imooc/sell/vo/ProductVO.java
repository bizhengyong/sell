package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(保护类目)
 * @author bizy
 * @date 2019/9/23 20:42
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
