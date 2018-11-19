/**
 *
 */
package com.person.ssm.entities;

import java.util.Date;

/**
 * @author HS
 * 店铺
 */
public class Shop {

    private Long shopId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    //-1.不可用 0.审核中 1.可用
    private Integer enableStatus;
    //超级管理员给店家的提醒
    private String advice;
    private Area area;
    private PersonInfo owner;
    private ShopCategory shopCategory;

    /**
     * @return the shopId
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * @param shopId the shopId to set
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * @return the shopName
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * @param shopName the shopName to set
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * @return the shopDesc
     */
    public String getShopDesc() {
        return shopDesc;
    }

    /**
     * @param shopDesc the shopDesc to set
     */
    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    /**
     * @return the shopAddr
     */
    public String getShopAddr() {
        return shopAddr;
    }

    /**
     * @param shopAddr the shopAddr to set
     */
    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the shopImg
     */
    public String getShopImg() {
        return shopImg;
    }

    /**
     * @param shopImg the shopImg to set
     */
    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    /**
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the lastEditTime
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }

    /**
     * @param lastEditTime the lastEditTime to set
     */
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    /**
     * @return the enableStatus
     */
    public Integer getEnableStatus() {
        return enableStatus;
    }

    /**
     * @param enableStatus the enableStatus to set
     */
    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    /**
     * @return the advice
     */
    public String getAdvice() {
        return advice;
    }

    /**
     * @param advice the advice to set
     */
    public void setAdvice(String advice) {
        this.advice = advice;
    }

    /**
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * @return the owner
     */
    public PersonInfo getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(PersonInfo owner) {
        this.owner = owner;
    }

    /**
     * @return the shopCategory
     */
    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    /**
     * @param shopCategory the shopCategory to set
     */
    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }
}
