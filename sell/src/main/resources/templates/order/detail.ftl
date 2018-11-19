<#--<html>-->
<#--<#include "../common/header.ftl">-->
<#--<body>-->
<#--<div id="wrapper" class="toggled">-->
<#--<#include "../common/nav.ftl">-->
<#--&lt;#&ndash;<div id="page-content-wrapper">&ndash;&gt;-->
<#--&lt;#&ndash;<div class="container-fluid">&ndash;&gt;-->
<#--&lt;#&ndash;<div class="row clearfix">&ndash;&gt;-->
<#--&lt;#&ndash;<div class="col-md-4 column">&ndash;&gt;-->
<#--&lt;#&ndash;<table class="table table-bordered table-hover">&ndash;&gt;-->
<#--&lt;#&ndash;<thead>&ndash;&gt;-->
<#--&lt;#&ndash;<tr>&ndash;&gt;-->
<#--&lt;#&ndash;<th>&ndash;&gt;-->
<#--&lt;#&ndash;订单ID&ndash;&gt;-->
<#--&lt;#&ndash;</th>&ndash;&gt;-->
<#--&lt;#&ndash;<th>&ndash;&gt;-->
<#--&lt;#&ndash;订单总金额&ndash;&gt;-->
<#--&lt;#&ndash;</th>&ndash;&gt;-->
<#--&lt;#&ndash;</tr>&ndash;&gt;-->
<#--&lt;#&ndash;</thead>&ndash;&gt;-->
<#--&lt;#&ndash;<tbody>&ndash;&gt;-->
<#--&lt;#&ndash;<tr>&ndash;&gt;-->
<#--&lt;#&ndash;<td>&ndash;&gt;-->
<#--&lt;#&ndash;${orderDTO.orderId}&ndash;&gt;-->
<#--&lt;#&ndash;</td>&ndash;&gt;-->
<#--&lt;#&ndash;<td>&ndash;&gt;-->
<#--&lt;#&ndash;${orderDTO.orderAmount}&ndash;&gt;-->
<#--&lt;#&ndash;</td>&ndash;&gt;-->
<#--&lt;#&ndash;</tr>&ndash;&gt;-->
<#--&lt;#&ndash;</tbody>&ndash;&gt;-->
<#--&lt;#&ndash;</table>&ndash;&gt;-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->

<#--&lt;#&ndash;&lt;#&ndash;订单详情表数据&ndash;&gt;&ndash;&gt;-->
<#--&lt;#&ndash;<div class="col-md-12 column">&ndash;&gt;-->
<#--&lt;#&ndash;<table class="table table-bordered table-hover">&ndash;&gt;-->
<#--&lt;#&ndash;<thead>&ndash;&gt;-->
<#--&lt;#&ndash;<tr>&ndash;&gt;-->
<#--&lt;#&ndash;<th>商品ID</th>&ndash;&gt;-->
<#--&lt;#&ndash;<th>商品名称</th>&ndash;&gt;-->
<#--&lt;#&ndash;<th>单价</th>&ndash;&gt;-->
<#--&lt;#&ndash;<th>数量</th>&ndash;&gt;-->
<#--&lt;#&ndash;<th>总额</th>&ndash;&gt;-->
<#--&lt;#&ndash;</tr>&ndash;&gt;-->
<#--&lt;#&ndash;</thead>&ndash;&gt;-->
<#--&lt;#&ndash;<tbody>&ndash;&gt;-->
<#--&lt;#&ndash;<#list orderDTO.orderDetails as orderDetail>&ndash;&gt;-->
<#--&lt;#&ndash;<tr>&ndash;&gt;-->
<#--&lt;#&ndash;<td>&ndash;&gt;-->
<#--&lt;#&ndash;${orderDetail.productId}&ndash;&gt;-->
<#--&lt;#&ndash;</td>&ndash;&gt;-->
<#--&lt;#&ndash;<td>&ndash;&gt;-->
<#--&lt;#&ndash;${orderDetail.productName}&ndash;&gt;-->
<#--&lt;#&ndash;</td>&ndash;&gt;-->
<#--&lt;#&ndash;<td>&ndash;&gt;-->
<#--&lt;#&ndash;${orderDetail.productPrice}&ndash;&gt;-->
<#--&lt;#&ndash;</td>&ndash;&gt;-->
<#--&lt;#&ndash;<td>&ndash;&gt;-->
<#--&lt;#&ndash;${orderDetail.productQuantity}&ndash;&gt;-->
<#--&lt;#&ndash;</td>&ndash;&gt;-->
<#--&lt;#&ndash;<td>&ndash;&gt;-->
<#--&lt;#&ndash;${orderDetail.productQuantity * orderDetail.productPrice}&ndash;&gt;-->
<#--&lt;#&ndash;</td>&ndash;&gt;-->
<#--&lt;#&ndash;</tr>&ndash;&gt;-->
<#--&lt;#&ndash;</#list>&ndash;&gt;-->
<#--&lt;#&ndash;</tbody>&ndash;&gt;-->
<#--&lt;#&ndash;</table>&ndash;&gt;-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->

<#--&lt;#&ndash;&lt;#&ndash;操作&ndash;&gt;&ndash;&gt;-->
<#--&lt;#&ndash;<div class="col-md-12 column">&ndash;&gt;-->
<#--&lt;#&ndash;<#if orderDTO.getOrderStatusEnum().message == "新订单">&ndash;&gt;-->
<#--&lt;#&ndash;<a href="/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-success btn-lg">完结订单</a>&ndash;&gt;-->
<#--&lt;#&ndash;<a href="/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-danger btn-lg">取消订单</a>&ndash;&gt;-->
<#--&lt;#&ndash;</#if>&ndash;&gt;-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->
<#--<div class="container">-->
<#--<div class="row clearfix">-->
<#--<div class="col-md-12 column">-->
<#--<table class="table table-bordered">-->
<#--<thead>-->
<#--<tr>-->
<#--<th>订单ID</th>-->
<#--<th>订单总金额</th>-->
<#--</tr>-->
<#--</thead>-->
<#--<tbody>-->
<#--<tr>-->
<#--<td>${orderDTO.orderId}</td>-->
<#--<td>${orderDTO.orderAmount}</td>-->
<#--</tr>-->
<#--</tbody>-->
<#--</table>-->
<#--<h3 class="text-center">-->
<#--订单详情-->
<#--</h3>-->
<#--<table class="table table-bordered">-->
<#--<thead>-->
<#--<tr>-->
<#--<th>商品ID</th>-->
<#--<th>商品名称</th>-->
<#--<th>单价</th>-->
<#--<th>数量</th>-->
<#--<th>总额</th>-->
<#--</tr>-->
<#--</thead>-->
<#--<tbody>-->
<#--<#list orderDTO.orderDetails as orderdetail>-->
<#--<tr>-->
<#--<td>${orderdetail.productId}</td>-->
<#--<td>${orderdetail.productName}</td>-->
<#--<td>${orderdetail.productPrice}</td>-->
<#--<td>${orderdetail.productQuantity}</td>-->
<#--<td>${orderdetail.productPrice * orderdetail.productQuantity}</td>-->
<#--</tr>-->
<#--</#list>-->
<#--</tbody>-->
<#--</table>-->
<#--<a type="button" class="btn btn-success btn-lg">完结订单</a>-->
<#--<a type="button" class="btn btn-danger btn-lg">取消订单</a>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</body>-->
<#--</html>-->

<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../common/nav.ftl">
<#--主要内容区域-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>
                                订单ID
                            </th>
                            <th>
                                订单总金额
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                            ${orderDTO.orderId}
                            </td>
                            <td>
                            ${orderDTO.orderAmount}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            <#--订单详情表数据-->
                <div class="col-md-12 column">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>商品ID</th>
                            <th>商品名称</th>
                            <th>单价</th>
                            <th>数量</th>
                            <th>总额</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list orderDTO.orderDetails as orderDetail>
                    <tr>
                        <td>
                            ${orderDetail.productId}
                        </td>
                        <td>
                            ${orderDetail.productName}
                        </td>
                        <td>
                            ${orderDetail.productPrice}
                        </td>
                        <td>
                            ${orderDetail.productQuantity}
                        </td>
                        <td>
                            ${orderDetail.productQuantity * orderDetail.productPrice}
                        </td>
                    </tr>
                    </#list>
                        </tbody>
                    </table>
                </div>

            <#--操作-->
                <div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().message == "新订单">
                    <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button"
                       class="btn btn-default btn-lg">完结订单</a>
                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button"
                       class="btn btn-danger btn-lg">取消订单</a>
                </#if>
                </div>

            </div>
        </div>
    </div>
</div>
</body>

</html>

