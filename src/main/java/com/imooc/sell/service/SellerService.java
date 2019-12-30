package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

/**
 * 卖家端
 * @author bizy
 * @date 2019/12/29 17:28
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
