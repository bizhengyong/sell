package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 买家
 * @author bizy
 * @date 2019/11/17 20:38
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
