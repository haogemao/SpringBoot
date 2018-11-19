package com.person.springboot.service;

import com.person.springboot.dto.CartDTO;
import com.person.springboot.entities.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductInfoService {

    /**
     * 查询所有在架商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品列表
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 更新和新增
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 查询一个商品
     *
     * @param id
     * @return
     */
    ProductInfo findOne(String id);

    /**
     * 加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     */
    ProductInfo offSale(String productId);

}
