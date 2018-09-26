package com.person.springboot.form;

import com.person.springboot.enums.ProductInfoStatusEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductInfoForm {
    private String productId;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    private String productName;

    /**
     * 商品价格
     */
    @NotNull(message = "单价不能为空")
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    @NotNull(message = "库存不能为空")
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
     * 类目编号
     */
    @NotNull(message = "类目编号不能为空")
    private Integer categoryType;
}
