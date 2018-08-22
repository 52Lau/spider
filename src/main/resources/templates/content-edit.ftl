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

        <input type="hidden" class="layui-input" name="id"  value="${content.id}" >
        <div class="layui-form-item">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <select name="catid" lay-verify="required"  >
                    <option value=""></option>
                    <option value="0" <#if content.catid=0> selected="selected"</#if>>北京</option>
                    <option value="1" <#if content.catid=1> selected="selected"</#if>>上海</option>
                    <option value="2" <#if content.catid=2> selected="selected"</#if>>广州</option>
                    <option value="3" <#if content.catid=3> selected="selected"</#if>>深圳</option>
                    <option value="4" <#if content.catid=4> selected="selected"</#if>>杭州</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="context" id="LAY_demo1" style="display: none">
                    把编辑器的初始内容放在这textarea即可
                </textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
               <input type="checkbox" name="isvideoaudio" title="压制" <#if content.isvideoaudio=0> checked</#if> value="0">
                <input type="checkbox" name="issubtitle" title="字幕" <#if content.issubtitle=0> checked</#if> value="0">
                <input type="checkbox" name="isclip" title="剪辑"  <#if content.isclip=0> checked</#if> value="0">
                <input type="checkbox" name="issend" title="发布"  <#if content.issend=0> checked</#if> value="0">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input class="layui-btn" type="button" value="提交" onclick="login()">
                <#--<button class="layui-btn" id="btn-login" onclick="login()"  >立即提交</button>-->
                <input class="layui-btn"  type="reset" value="重置">
            </div>
        </div>
    </form>
</div>
<script>
    layui.use('layedit', function(){
        var layedit = layui.layedit
                ,$ = layui.jquery;

        //构建一个默认的编辑器
        var index = layedit.build('LAY_demo1');

        //编辑器外部操作
        var active = {
            content: function(){
                //alert(layedit.getContent(index)); //获取编辑器内容
            }
            ,text: function(){
                alert(layedit.getText(index)); //获取编辑器纯文本内容
            }
            ,selection: function(){
                alert(layedit.getSelection(index));
            }
        };

        $('.site-demo-layedit').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素 value=""
            //,value: '2018-08-18'
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

</script>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer;

        /*//自定义验证规则
        form.verify({
            nikename: function(value){
                if(value.length < 5){
                    return '昵称至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            login();
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });*/



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
            url: "${request.contextPath}/content/update" ,//url
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
<#--<script>
    //var app = angular.module("myApp",["checklist-model"]);
    var app = angular.module('myApp', ["checklist-model"]);
    app.controller('formCtrl', function($scope, $http) {
        $http.get("/youtube/get/404")
                .then(function (result) {
                    $scope.youtube = result.data;
                    $scope.ss=result.data.issend;
                });

        $scope.roles = [
            'guest',
            'user',
            'customer',
            'admin'
        ];
        $scope.user = {
            roles: ['user']
        };

        $scope.reset = function() {
            $scope.youtube = angular.copy($scope.youtube);
        };
        $scope.filtStatus= {
            2:"false",
            1:"true",
        }

        $scope.reset();
    });


</script>-->

</body>

</html>