package com.imooc.sell.service.impl;

import com.imooc.sell.config.WechatAccountConfig;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author bizy
 * @date 2020/1/1 13:43
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(wechatAccountConfig.getTemplateId().get("orderStatus"));
//        templateMessage.setToUser(orderDTO.getBuyerOpenid());
        templateMessage.setToUser("oPsbav0wuc0zNcO9wEtmk8fUgM5g");

        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        String productNames = "";
        for (OrderDetail orderDetail : orderDetailList) {
            productNames += orderDetail.getProductName() + " ";
        }

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","亲,记得收货"),
                new WxMpTemplateData("keyword1","念念餐厅-毕氏"),
                new WxMpTemplateData("keyword2","15901292250"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5","￥"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("keyword6",orderDTO.getBuyerName()),
                new WxMpTemplateData("keyword7",orderDTO.getBuyerPhone()),
                new WxMpTemplateData("keyword8",orderDTO.getBuyerAddress()),
                new WxMpTemplateData("keyword9", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(orderDTO.getCreateTime())),
                new WxMpTemplateData("keyword10", productNames),
                new WxMpTemplateData("remark","欢迎再次光临!")
        );

        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            templateMessage.setToUser("oPsbav86FeE4qgmMU544UPvOvWHg");
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败，{}");
        }
    }
}
