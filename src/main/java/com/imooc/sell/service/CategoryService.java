package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author bizy
 * @date 2019/9/22 21:30
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
