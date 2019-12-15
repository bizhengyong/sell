package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * @author bizy
 * @date 2019/12/1 14:47
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}
