package com.person.springboot.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class ProductCategoryForm {
    private Integer categoryId;

    //类目名字
    @NotEmpty(message = "类目名字不能为空")
    private String categoryName;

    //类目编号
    @NotNull(message = "类目编号不能为空")
    private Integer categoryType;
}
