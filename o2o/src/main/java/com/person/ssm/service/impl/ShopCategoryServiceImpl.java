/**
 *
 */
package com.person.ssm.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.person.ssm.dao.ShopCategoryDao;
import com.person.ssm.entities.ShopCategory;
import com.person.ssm.exception.ShopCategoryExecution;
import com.person.ssm.service.ShopCategoryService;

/**
 * @author HS
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    /**
     *
     */
    public ShopCategoryServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#getFirstLevelShopCategoryList()
     */
    @Override
    public List<ShopCategory> getFirstLevelShopCategoryList() throws IOException {
        List<ShopCategory> shopCategoryList = null;
        ShopCategory shopCategoryCondition = new ShopCategory();
        // 当shopCategoryId不为空的时候，查询的条件会变为 where parent_id is null
        shopCategoryCondition.setShopCategoryId(1L);
        shopCategoryList = shopCategoryDao
                .queryShopCategory(shopCategoryCondition);
        return shopCategoryList;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#getShopCategoryList(java.lang.Long)
     */
    @Override
    public List<ShopCategory> getShopCategoryList(Long parentId) throws IOException {
        // TODO Auto-generated method stub
        ShopCategory shopCategoryCondition = new ShopCategory();
        shopCategoryCondition.setParentId(parentId);
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#getAllSecondLevelShopCategory()
     */
    @Override
    public List<ShopCategory> getAllSecondLevelShopCategory() throws IOException {
        // TODO Auto-generated method stub
        List<ShopCategory> shopCategoryList = null;
        ShopCategory shopCategoryCondition = new ShopCategory();
        // 当shopCategoryDesc不为空的时候，查询的条件会变为 where parent_id is not null
        shopCategoryCondition.setShopCategoryDesc("ALLSECOND");
        shopCategoryList = shopCategoryDao
                .queryShopCategory(shopCategoryCondition);
        return shopCategoryList;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#getShopCategoryById(java.lang.Long)
     */
    @Override
    public ShopCategory getShopCategoryById(Long shopCategoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#addShopCategory(com.person.ssm.entities.ShopCategory, org.springframework.web.multipart.commons.CommonsMultipartFile)
     */
    @Override
    public ShopCategoryExecution addShopCategory(ShopCategory shopCategory, CommonsMultipartFile thumbnail) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#modifyShopCategory(com.person.ssm.entities.ShopCategory, org.springframework.web.multipart.commons.CommonsMultipartFile, boolean)
     */
    @Override
    public ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory, CommonsMultipartFile thumbnail,
                                                    boolean thumbnailChange) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#removeShopCategory(long)
     */
    @Override
    public ShopCategoryExecution removeShopCategory(long shopCategoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopCategoryService#removeShopCategoryList(java.util.List)
     */
    @Override
    public ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList) {
        // TODO Auto-generated method stub
        return null;
    }

}
