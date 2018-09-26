package com.person.springboot.service;

import com.person.springboot.entities.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory findOne(Integer productCategoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
