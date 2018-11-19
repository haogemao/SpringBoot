/**
 *
 */
package com.person.ssm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author HS
 */
public class Product implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1517703164436424767L;

    private Long productId;
    private String productName;
    private String productDesc;
    private String imgAddr;// 简略图
    private String normalPrice;
    private String promotionPrice;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    //-1.不可用 0.下架 1.在前端展示系统展示
    private Integer enableStatus;
    private Integer point;

    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;

    /**
     * @return the productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productDesc
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * @param productDesc the productDesc to set
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * @return the imgAddr
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     * @param imgAddr the imgAddr to set
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    /**
     * @return the normalPrice
     */
    public String getNormalPrice() {
        return normalPrice;
    }

    /**
     * @param normalPrice the normalPrice to set
     */
    public void setNormalPrice(String normalPrice) {
        this.normalPrice = normalPrice;
    }

    /**
     * @return the promotionPrice
     */
    public String getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * @param promotionPrice the promotionPrice to set
     */
    public void setPromotionPrice(String promotionPrice) {
        this.promotionPrice = promotionPrice;
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
     * @return the point
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * @return the productImgList
     */
    public List<ProductImg> getProductImgList() {
        return productImgList;
    }

    /**
     * @param productImgList the productImgList to set
     */
    public void setProductImgList(List<ProductImg> productImgList) {
        this.productImgList = productImgList;
    }

    /**
     * @return the productCategory
     */
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * @param productCategory the productCategory to set
     */
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * @return the shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * @param shop the shop to set
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
