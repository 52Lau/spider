<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="${request.contextPath}/static/js/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/static/js/xadmin.js"></script>
    <script type="text/javascript" src="https://cdn.staticfile.org/checklist-model/1.0.0/checklist-model.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body" id="myDiv">
    <form class="layui-form" id="form1" >

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">暱称</label>
            <div class="layui-input-block">
                <input type="text" name="name"  placeholder="暱称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email"  placeholder="邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">手机</label>
            <div class="layui-input-block">
                <input type="text" name="phone"  placeholder="手机" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="text" name="pwd"  placeholder="密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">平台</label>
            <div class="layui-input-block">
                <select name="platform" id="platform" style="height: 40px;">
                    <option value="">选择平台</option>
                    <option value="0">企鹅号</option>
                    <option value="1">大鱼号</option>
                    <option value="2">一点号</option>
                    <option value="3">百家号</option>
                    <option value="4">东方号</option>
                    <option value="5">网易号</option>
                    <option value="6">大风号</option>
                    <option value="7">头条号</option>
                    <option value="8">凤凰号</option>
                    <option value="9">搜狐号</option>
                    <option value="10">趣头条</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <select name="type" id="type" style="height: 40px;">
                    <option value="">选择类型</option>
                    <option value="0">Music</option>
                    <option value="1">Youtube</option>
                    <option value="2">History</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">所属</label>
            <div class="layui-input-block">
                <input type="text"  name="owner" placeholder="所属" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">IdCard</label>
            <div class="layui-input-block">
                <input type="text"  name="idcard" placeholder="IdCard" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input class="layui-btn" type="button" value="提交" onclick="login()">
                <input class="layui-btn"  type="reset" value="重置">
            </div>
        </div>
    </form>
</div>

<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer;
    });
</script>

<script type="text/javascript">
    $.fn.serializeObject = function()
    {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
    function login() {
        var v=$('#form1').serializeObject();
        $.ajax({
            //几个参数需要注意一下
            type: "PUT",//方法类型
            dataType: "text",//预期服务器返回的数据类型
            url: "${request.contextPath}/account/insert" ,//url
            data: JSON.stringify(v),
            contentType : "application/json",
            success: function (result) {
                if (result==200) {
                    //加载层
                    //var indexs = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
                    //layer.msg('修改成功！');
                    layer.msg('玩命卖萌中', function(){
                        //关闭后的操作
                        //window.parent.location.reload();
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layui.table.reload('youtubeTable',{page:{curr:1}});
                        parent.layer.close(index);
                    });
                    /*var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);//关闭当前页*/
                    //location.replace(location.href);



                }else{
                    layer.msg('修改失败！');
                }

            },
            error : function() {
                alert("error");
            }
        });
    }

</script>
</body>

</html>