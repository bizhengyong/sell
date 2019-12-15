package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author bizy
 * @date 2019/9/22 20:05
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
