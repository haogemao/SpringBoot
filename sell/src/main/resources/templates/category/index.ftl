<html>
    <#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
<#--边栏sidebar-->
        <#include "../common/nav.ftl">
<#--主要内容区域-->
    <div id="page-content-wrapper">
    <#--fluid-流动布局-->
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label for="exampleInputEmail1">名字</label><input name="categoryName" type="text" class="form-control" value="${(productCategory.categoryName)!""}" />
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">type</label><input name="categoryType" type="text" class="form-control" value="${(productCategory.categoryType)!""}" />
                        </div>
                        <input hidden type="text" name="productId" value="${(productCategory.categoryId)!""}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

