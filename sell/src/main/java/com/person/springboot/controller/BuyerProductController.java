package com.person.springboot.controller;

import com.person.springboot.entities.ProductCategory;
import com.person.springboot.entities.ProductInfo;
import com.person.springboot.service.impl.ProductCategoryServiceImpl;
import com.person.springboot.service.impl.ProductInfoServiceImpl;
import com.person.springboot.utils.ResultVOUtil;
import com.person.springboot.vo.ProductInfoVO;
import com.person.springboot.vo.ProductVO;
import com.person.springboot.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductCategoryServiceImpl productCategoryServiceImpl;

    @Autowired
    private ProductInfoServiceImpl productInfoServiceImpl;

    @GetMapping("/list")
    private ResultVO list() {
        //查询所有上架商品
        List<ProductInfo> productInfoList = productInfoServiceImpl.findUpAll();
        //查询类目(一次性查询)lamba表达式
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryServiceImpl.findByCategoryTypeIn(categoryTypeList);
        //拼接数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (int i = 0; i < productCategoryList.size(); i++) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategoryList.get(i).getCategoryName());
            productVO.setCategoryType(productCategoryList.get(i).getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategoryList.get(i).getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
