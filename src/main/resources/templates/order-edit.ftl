<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./static/css/font.css">
    <link rel="stylesheet" href="./static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./static/lib/layui/layui.js" charset="utf-8"></script>
    <script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
    <script type="text/javascript" src="./static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body" ng-app="myApp" ng-controller="formCtrl">
    <form class="layui-form" action="">
        <select ng-model="com" ng-options="x.game_id as x.game_name for x in game_info">
        </select>
        <input type="text" value="{{filtStatus[youtube.issubtitle]}}">
        <input type="hidden" class="layui-input" name="id" id="id" ng-model="youtube.id">
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">视频名字</label>
            <div class="layui-input-block">
                <textarea name="desc" placeholder="请输入内容、即描述" class="layui-textarea"  ng-model="youtube.name"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">分类</label>
            <div class="layui-input-block">
                <select name="city" lay-verify="required" ng-model="youtube.catid">
                    <option value=""></option>
                    <option value="0">北京</option>
                    <option value="1">上海</option>
                    <option value="2">广州</option>
                    <option value="3">深圳</option>
                    <option value="4">杭州</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">日期</label>
            <div class="layui-input-block">
                <#--ng-model="youtube.createdate"-->
                <input class="layui-input" placeholder="时间" name="createdate" id="start" value="{{youtube.createdate | date:'yyyy-MM-dd'}}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
               <#-- <input type="checkbox" name="like[isvideoaudio]" title="压制" ng-checked="true" >-->
                <input type="checkbox" name="like[issubtitle]" title="字幕"  ng-checked="{{filtStatus[youtube.issubtitle]}}">
                <input type="checkbox" name="like[isclip]" title="剪辑"  ng-checked="{{filtStatus[youtube.isclip]}}">
                <input type="checkbox" name="like[issend]" title="发布"  ng-checked="{{filtStatus[youtube.issend]}}">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
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
            elem: '#start' //指定元素
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
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });


    });
</script>
<script>
    var app = angular.module('myApp', []);
    app.controller('formCtrl', function($scope, $http) {
        $http.get("/youtube/get/404")
                .then(function (result) {
                    $scope.youtube = result.data;
                    $scope.com =result.data.issubtitle;
                });
        $scope.game_info =  [
            {game_id : 0 , game_name:'全部游戏'},
            {game_id : 1 , game_name:'穿越火线'},
            {game_id : 2 , game_name:'地下城与勇士'},
            {game_id : 3 , game_name:'使命召唤'},
            {game_id : 4 , game_name:'英雄联盟'},
            {game_id : 5 , game_name:'逆战'},
        ];

        $scope.reset = function() {
            $scope.youtube = angular.copy($scope.youtube);
        };
        $scope.filtStatus= {
            2:"false",
            1:"true",
        }

        $scope.reset();
    });

</script>

</body>

</html>