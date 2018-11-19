<html>
<head>
    <meta charset="utt-8">
    <title>成功提示</title>
    <link>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
            <#--<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>-->
                <h4>
                    成功!
                <#-- 如果模板的msg没有值，就给一个默认值 -->
                </h4> <strong>${msg!"操作成功"}</strong> Best check yo self, you're not looking too good. <a href="${url}"
                                                                                                         class="alert-link">3s后自动跳转</a>
            </div>
        </div>
    </div>
</div>
<script>
    setTimeout("location.href='${url}'", 3000);
</script>
</body>
</html>