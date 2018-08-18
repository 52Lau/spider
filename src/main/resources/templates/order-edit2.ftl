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
<div class="x-body" ng-app="myApp" ng-controller="formCtrl">
    <form class="layui-form" action="">

        <input type="hidden" class="layui-input" name="id" id="id" value="${youtube.id}" >
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">视频名字</label>
            <div class="layui-input-block">
                <textarea name="name" placeholder="请输入内容、即描述" class="layui-textarea"  >${youtube.name}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">分类</label>
            <div class="layui-input-block">
                <select name="catid" lay-verify="required"  >
                    <option value=""></option>

                    <#--<select class="ctform" name="grossProfit.publicfactionName">
                        <option value="">请选择</option>
                        <s:iterator value="loginUserInfos" status="index">
                            <option value="${factionName}" ${grossProfit.publicfactionName==factionName?'selected="selected"':'' }>${factionName }帮</option>
                        </s:iterator>

                    </select>-->

                    <option value="0" <#if youtube.catid=0> selected="selected"</#if>>北京</option>
                    <option value="1" <#if youtube.catid=1> selected="selected"</#if>>上海</option>
                    <option value="2" <#if youtube.catid=2> selected="selected"</#if>>广州</option>
                    <option value="3" <#if youtube.catid=3> selected="selected"</#if>>深圳</option>
                    <option value="4" <#if youtube.catid=4> selected="selected"</#if>>杭州</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">日期</label>
            <div class="layui-input-block">
                <#--ng-model="youtube.createdate"-->
                <input class="layui-input" placeholder="时间" name="createdate" id="start" value="${youtube.createdate?string('yyyy-MM-dd')} ">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
               <input type="checkbox" name="isvideoaudio" title="压制" <#if youtube.isvideoaudio=0> checked</#if> >
                <input type="checkbox" name="issubtitle" title="字幕" <#if youtube.issubtitle=0> checked</#if> >
                <input type="checkbox" name="isclip" title="剪辑"  <#if youtube.isclip=0> checked</#if>>
                <input type="checkbox" name="issend" title="发布"  <#if youtube.issend=0> checked</#if>>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="remarks" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
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

        //自定义验证规则
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
        });

        function login() {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/users/login" ,//url
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
        }

    });
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