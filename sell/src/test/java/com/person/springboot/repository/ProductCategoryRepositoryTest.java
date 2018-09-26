package com.person.springboot.repository;

import com.person.springboot.entities.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@EnableCaching
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void test1(){
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1);
//        log.info(productCategoryRepository.getOne(1).toString());
        log.info(productCategory.toString());
    }

    @Test
    public  void testSave(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("热销版");
        productCategory.setCategoryType(1);
        ProductCategory productCategory1 = productCategoryRepository.save(productCategory);
        Assert.assertNotEquals(null, productCategory1);
    }
}