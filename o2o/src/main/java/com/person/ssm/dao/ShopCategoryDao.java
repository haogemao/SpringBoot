/**
 *
 */
package com.person.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.person.ssm.entities.ShopCategory;

/**
 * @author HS
 */
public interface ShopCategoryDao {

    /**
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory(
            @Param("shopCategoryCondition") ShopCategory shopCategoryCondition);

    /**
     * @param shopCategoryId
     * @return
     */
    ShopCategory queryShopCategoryById(long shopCategoryId);

    /**
     * @param shopCategoryIdList
     * @return
     */
    List<ShopCategory> queryShopCategoryByIds(List<Long> shopCategoryIdList);

    /**
     * @param shopCategory
     * @return
     */
    int insertShopCategory(ShopCategory shopCategory);

    /**
     * @param shopCategory
     * @return
     */
    int updateShopCategory(ShopCategory shopCategory);

    /**
     * @param shopCategoryId
     * @return
     */
    int deleteShopCategory(long shopCategoryId);

    /**
     * @param shopCategoryIdList
     * @return
     */
    int batchDeleteShopCategory(List<Long> shopCategoryIdList);
}
