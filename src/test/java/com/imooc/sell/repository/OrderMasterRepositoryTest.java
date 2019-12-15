package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author bizy
 * @date 2019/9/24 20:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师妹");
        orderMaster.setBuyerPhone("1234567890123");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid("OPENID");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenidTest() {
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster> result = repository.findByBuyerOpenid("OPENID", request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

}