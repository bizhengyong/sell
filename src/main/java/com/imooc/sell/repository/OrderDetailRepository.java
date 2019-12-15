package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bizy
 * @date 2019/9/24 20:25
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
