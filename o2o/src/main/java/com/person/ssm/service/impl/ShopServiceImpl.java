/**
 *
 */
package com.person.ssm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.person.ssm.dao.ShopDao;
import com.person.ssm.dto.ShopExecution;
import com.person.ssm.entities.Shop;
import com.person.ssm.enums.ShopStateEnum;
import com.person.ssm.exception.ShopOperationException;
import com.person.ssm.service.ShopService;
import com.person.ssm.util.FileUtil;
import com.person.ssm.util.ImageUtil;

/**
 * @author HS
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopService#getShopList(com.person.ssm.entities.Shop, int, int)
     */
    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopService#getByEmployeeId(long)
     */
    @Override
    public ShopExecution getByEmployeeId(long employeeId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopService#getByShopId(long)
     */
    @Override
    public Shop getByShopId(long shopId) {
        // TODO Auto-generated method stub
        return shopDao.queryByShopId(shopId);
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopService#addShop(com.person.ssm.entities.Shop, org.springframework.web.multipart.commons.CommonsMultipartFile)
     */
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                try {
                    if (shopImg != null) {
                        addShopImg(shop, shopImg);
                        effectedNum = shopDao.updateShop(shop);
                        if (effectedNum <= 0) {
                            throw new ShopOperationException("创建图片地址失败");
                        }
                    }
                } catch (Exception e) {
                    throw new ShopOperationException("addShopImg error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw new ShopOperationException("insertShop error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }

    /* (non-Javadoc)
     * @see com.person.ssm.service.ShopService#modifyShop(com.person.ssm.entities.Shop, org.springframework.web.multipart.commons.CommonsMultipartFile)
     */
    @Override
    public ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) {
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOPID);
        } else {
            try {
                //1.判断是否需要处理图片
                if (shopImg != null) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop.getShopImg() != null) {
                        FileUtil.deleteFile(tempShop.getShopImg());
                    }
                    addShopImg(shop, shopImg);
                }
                //2.更新店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {// 创建成功
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS, shop);
                }
            } catch (Exception e) {
                throw new RuntimeException("modifyShop error: " + e.getMessage());
            }
        }
    }

}
