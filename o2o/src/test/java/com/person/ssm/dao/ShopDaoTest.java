/**
 *
 */
package com.person.ssm.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.person.ssm.BaseTest;
import com.person.ssm.entities.Area;
import com.person.ssm.entities.PersonInfo;
import com.person.ssm.entities.Shop;
import com.person.ssm.entities.ShopCategory;

/**
 * @author HS
 */
public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() throws Exception {
        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(8L);
        shop.setOwner(personInfo);
        Area area = new Area();
        area.setAreaId(3);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(12L);
        shop.setShopName("mytest1");
        shop.setShopDesc("mytest1");
        shop.setShopAddr("testaddr1");
        shop.setPhone("13810524526");
        shop.setShopImg("test1");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("审核中");
        shop.setArea(area);
        shop.setShopCategory(sc);
        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    public void testDUpdateShop() {
        long shopId = 29;
        Shop shop = new Shop();
        shop.setShopId(shopId);
        Area area = new Area();
        area.setAreaId(4);
        shop.setArea(area);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(13L);
        shop.setShopCategory(shopCategory);
        shop.setShopName("四季花");
        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1, effectedNum);
    }
}
