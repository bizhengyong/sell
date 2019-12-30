package com.imooc.sell.form;

import lombok.Data;

/**
 * @author bizy
 * @date 2019/12/29 16:31
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /*类目名称*/
    private String categoryName;

    /*类目编号*/
    private Integer categoryType;
}
