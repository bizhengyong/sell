package com.imooc.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author bizy
 * @date 2019/12/29 15:04
 */
@Data
public class ProductForm {
    private String productId;

    /*商品名称*/
    private String productName;

    /*单价*/
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 类目编号 */
    private Integer categoryType;
}
