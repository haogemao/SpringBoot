<html>
    <#include "../common/header.ftl">
    <body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/login">
                        <div class="form-group">
                            <label for="exampleInputEmail1">openId</label><input type="text" class="form-control" id="openid" name="openid" />
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="password" name="password" />
                        </div>
                        <#--<div class="form-group">-->
                            <#--<label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />-->
                            <#--<p class="help-block">-->
                                <#--Example block-level help text here.-->
                            <#--</p>-->
                        <#--</div>-->
                        <#--<div class="checkbox">-->
                            <#--<label><input type="checkbox" />Check me out</label>-->
                        <#--</div> -->
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>