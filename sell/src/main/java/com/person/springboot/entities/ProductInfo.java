package com.person.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.person.springboot.enums.ProductInfoStatusEnum;
import com.person.springboot.utils.EnumUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 */
@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -3684878740696706456L;

    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图标
     */
    private String productIcon;

    /**
     * 商品状态
     */
    private Integer productStatus = ProductInfoStatusEnum.UP.getCode();

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 上架下架
     * 注意是公开方法
     *
     * @return
     */
    @JsonIgnore
    public ProductInfoStatusEnum getProductInfoStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductInfoStatusEnum.class);
    }
}
