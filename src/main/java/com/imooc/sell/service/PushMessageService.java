package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 微信模板消息推送
 * @author bizy
 * @date 2020/1/1 13:41
 */
public interface PushMessageService {
    
    /*
     * @description: 订单状态变更消息
     * @param:  
     * @author: bizy
     * @date: 2020/1/1 13:42
     */
    void orderStatus(OrderDTO orderDTO);
}
