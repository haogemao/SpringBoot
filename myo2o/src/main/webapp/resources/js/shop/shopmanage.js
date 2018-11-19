$(function () {
});
var shopId = getQueryString("shopId");

//商店信息
function shopmsg() {
    window.location.href = "/myo2o/shop/shopedit?shopId=" + shopId;
}

//商品管理
function productmanage() {
    window.location.href = "/myo2o/shop/productmanage?shopId=" + shopId;
}

//类别管理
function productcategorymanage() {
    window.location.href = "/myo2o/shop/productcategorymanage?shopId=" + shopId;
}

