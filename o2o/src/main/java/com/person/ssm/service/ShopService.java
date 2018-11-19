/**
 *
 */
package com.person.ssm.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.person.ssm.dto.ShopExecution;
import com.person.ssm.entities.Shop;

/**
 * @author HS
 */
public interface ShopService {

    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 查询该用户下面的店铺信息
     *
     * @param long employyeeId
     * @return List<Shop>
     * @throws Exception
     */
    ShopExecution getByEmployeeId(long employeeId);

    /**
     * 查询指定店铺信息
     *
     * @param long shopId
     * @return Shop shop
     */
    Shop getByShopId(long shopId);

    /**
     * 创建商铺
     *
     * @param Shop shop
     * @return ShopExecution shopExecution
     * @throws Exception
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);

    /**
     * 更新店铺信息（从店家角度）
     *
     * @param areaId
     * @param shopAddr
     * @param phone
     * @param shopImg
     * @param shopDesc
     * @return
     * @throws RuntimeException
     */
    ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg);
}
