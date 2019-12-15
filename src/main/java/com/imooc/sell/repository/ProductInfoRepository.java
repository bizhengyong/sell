package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author bizy
 * @date 2019/9/22 22:11
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
