package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.ProductForm;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家端商品
 * @author bizy
 * @date 2019/12/28 23:33
 */
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /*
     * @description:商品列表
     * @param:
     * @author: bizy
     * @date: 2019/12/28 23:35
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "3") Integer size,
                             Map<String, Object> map){
        PageRequest request = new PageRequest(page - 1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);
    }

    /*
     * @description:商品上架
     * @param:
     * @author: bizy
     * @date: 2019/12/29 0:30
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String,Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    /*
     * @description: 商品下架
     * @param:
     * @author: bizy
     * @date: 2019/12/29 0:36
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String,Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                      Map<String,Object> map){
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }

        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);

        return new ModelAndView("product/index",map);
    }

    /*
     * @description: 保存/更新
     * @param:
     * @author: bizy
     * @date: 2019/12/29 15:06
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productId不为空,说明是修改
            if (!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productService.findOne(form.getProductId());
            } else {
                form.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form,productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);

    }
}
