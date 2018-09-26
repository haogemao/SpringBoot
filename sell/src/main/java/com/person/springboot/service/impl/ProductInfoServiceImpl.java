package com.person.springboot.service.impl;

import com.person.springboot.dto.CartDTO;
import com.person.springboot.entities.ProductInfo;
import com.person.springboot.enums.ProductInfoStatusEnum;
import com.person.springboot.enums.ResultEnum;
import com.person.springboot.exceptions.SellException;
import com.person.springboot.repository.ProductInfoRepository;
import com.person.springboot.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@CacheConfig(cacheNames = "ProductInfo")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductInfoStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    @CachePut(key = "123")
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Cacheable(key = "123")
    public ProductInfo findOne(String id) throws NoSuchElementException {
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(id);
        return productInfoOptional.get();
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList) {
            ProductInfo productInfo = productInfoRepository.getOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    /**
     * 上架
     *
     * @param productId
     */
    @Override
    public ProductInfo onSale(String productId) {
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productId);
        try {
            productInfoOptional.get();
        }catch (NoSuchElementException e){
            log.error("【查询商品】 错误信息={}",e.getMessage());
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (productInfoOptional.get().getProductStatus() == ProductInfoStatusEnum.UP.getCode()){
            log.error("【商品上架】 错误信息={}","商品状态不正确");
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfoOptional.get().setProductStatus(ProductInfoStatusEnum.UP.getCode());
        return productInfoRepository.save(productInfoOptional.get());
    }

    /**
     * 下架
     *
     * @param productId
     */
    @Override
    public ProductInfo offSale(String productId) {
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productId);
        try {
            productInfoOptional.get();
        }catch (NoSuchElementException e){
            log.error("【查询商品】 错误信息={}",e.getMessage());
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (productInfoOptional.get().getProductStatus() == ProductInfoStatusEnum.DOWN.getCode()){
            log.error("【商品上架】 错误信息={}","商品状态不正确");
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfoOptional.get().setProductStatus(ProductInfoStatusEnum.DOWN.getCode());
        return productInfoRepository.save(productInfoOptional.get());
    }
}
