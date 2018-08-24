<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="${request.contextPath}/static/js/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./static/css/font.css">
    <link rel="stylesheet" href="./static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./static/js/xadmin.js"></script>
    <script type="text/javascript" src="./static/js/date-format.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">素材列表</a>
        <a>
          <cite>歷史列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">

        <div class="layui-input-inline">
            <input type="text" name="mention" id="mention" placeholder="词" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <select name="level1" id="level1" style="height: 40px;">
                <option value="">一级词义</option>
                <#--<option value="语言文化">语言文化</option>
                <option value="地理">地理</option>-->
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="level2" id="level2" style="height: 40px;">
                <option value="">二级词义</option>
                <#--<option value="语言文化">语言文化</option>
                <option value="文化人物">文化人物</option>-->
            </select>
        </div>
        <div class="layui-input-inline">
            <input type="text" name="desc" id="desc" placeholder="描述" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <select name="issend" id="issend" style="height: 40px;">
                <option value="">发布状态</option>
                <option value="0">已发布</option>
                <option value="1">未发布</option>
            </select>
        </div>
        <button class="layui-btn" id="layuibtn" data-type="reload">搜索</button>
        <#--</form>-->
    </div>
    <table id="demo" lay-filter="ying"></table>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });
    });

</script>

<script>
    //注意进度条依赖 element 模块，否则无法进行正常渲染和功能性操作
    layui.use('element', function(){
        var element = layui.element;
    });
</script>

<script>
    layui.use('table', function () {
        var table = layui.table;


        //第一个实例
        table.render({
            elem: '#demo'
            , height: 500
            , url: '/history/list/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'bdbkurl', title: 'url', width: 540}
                , {field: 'mention', title: '词', width: 60}
                , {field: 'confidence', title: '词义匹配度', width: 120, sort: true}
                , {field: 'level1', title: '一级语义', width: 120}
                , {field: 'level2', title: '二级语义', width: 120}
                , {field: 'desc', title: '描述', width: 150}
                , {field: 'issend', title: '发布', width: 60,templet:'#issendTpl'}
                , {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
            ]]
            , id: 'youtubeTable'
        });
        /*reload 表格重载*/
        var $ = layui.$, active = {
            reload: function () {
                var mention = $('#mention');
                var level1 = $('#level1');
                var level2 = $('#level2');
                var desc = $('#desc');
                var issend = $('#issend');

                //执行重载
                table.reload('youtubeTable', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {//参数
                        //key: {
                        mention : mention.val(),
                        level1 : level1.val(),
                        level2 : level2.val(),
                        desc : desc.val(),
                        issend : issend.val()
                        //}
                    }
                });
            }
        };

        /*表单提交按钮 配合上面的重载事件使用*/

        $('#layuibtn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        /* 监听工具条*/
        table.on('tool(ying)', function (obj) {
            var data = obj.data,
                    layEvent = obj.event;
            if (layEvent === 'detail') {
                //alert(data.id)
                //自定页
                layer.open({
                    type: 1,
                    skin: 'layui-layer-demo', //样式类名
                    closeBtn: 1, //不显示关闭按钮
                    anim: 2,
                    shadeClose: true, //开启遮罩关闭
                    content: '<h2><a href=\"'+data.bdbkurl+'\" target=\"_blank\">'+data.mention+'</a></h2>'
                });
            }else if (layEvent === 'edit') {
                layer.confirm('真的发布了?', function (index) {
                    console.log(data);
                    var obj={"id": data.id};
                    $.ajax({
                        url: "${request.contextPath}/history/update",
                        type: "PUT",
                        data: JSON.stringify(obj),
                        dataType: "json",
                        contentType : "application/json",
                        success: function (data) {
                            if (data = 200) {
                                layer.msg('玩命卖萌中', function(){
                                    layer.close(index);
                                    layui.table.reload('youtubeTable',{page:{curr:1}});
                                });
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }

                    });
                });
            }else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    console.log(data);
                    var obj={"id": data.id};
                    $.ajax({
                        url: "${request.contextPath}/history/update",
                        type: "DELETE",
                        data: JSON.stringify(obj),
                        dataType: "json",
                        contentType : "application/json",
                        success: function (data) {
                            if (data = 200) {
                                layer.msg('玩命卖萌中', function(){
                                    layer.close(index);
                                    layui.table.reload('youtubeTable',{page:{curr:1}});
                                });
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }

                    });
                });

            }


        });

    });

</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">发布</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <!-- 这里同样支持 laytpl 语法，如： -->
    {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  } }}


</script>
<script type="text/html" id="issendTpl">
    {{# if(d.issend == 0) { }}
    <span class="layui-badge-dot layui-bg-green"></span>
    {{# } else { }}
    <span class="layui-badge-dot layui-bg-orange"></span>
    {{# } }}
</script>

<!--时间格式化-->
<script src="./static/js/date-format.js" type="text/javascript" charset="utf-8"></script>
<script id="createdate" type="text/html">
    {{#
    var date = new Date();
    date.setTime(d.createdate);
    return date.Format("yyyy-MM-dd hh:mm:ss");
    }}
</script>
<script>
    $(document).ready(function () {
        $.ajax({
            type: "GET",
            url: "/history/level1List",
            success: function (data) {
                //for (var i = 0; i < data.length; i++) {
                for (var i in data) {
                    $("#level1").append("<option value= '"+data[i].level1 +"'>"+data[i].level1+"</option>");
                }

                //alert(data.catname)

                //}
            }
        });

        $.ajax({
            type: "GET",
            url: "/history/level1List",
            success: function (data) {
                //for (var i = 0; i < data.length; i++) {
                for (var i in data) {
                    $("#level2").append("<option value= '"+data[i].level1 +"'>"+data[i].level1+"</option>");
                }

                //alert(data.catname)

                //}
            }
        });
    });
</script>
</body>

</html>