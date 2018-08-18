<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
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
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <#--<form class="layui-form layui-col-md12 x-so" id="youtubeform">-->
            <input class="layui-input" placeholder="创建时间" name="createdate" id="start">
            <div class="layui-input-inline">
                <select name="catid" id="catid">
                    <option value="">分类</option>
                    <option value="0">科技</option>
                    <option value="1">军事</option>
                </select>
            </div>
            <div class="layui-input-inline">
                <select name="isvideoaudio" id="isvideoaudio">
                    <option value="">压制状态</option>
                    <option value="0">已压制</option>
                    <option value="1">未压制</option>
                </select>
            </div>
            <div class="layui-input-inline">
                <select name="issubtitle" id="issubtitle">
                    <option value="">字幕状态</option>
                    <option value="0">已确认</option>
                    <option value="1">待确认</option>
                </select>
            </div>
            <div class="layui-input-inline">
                <select name="isclip" id="isclip">
                    <option value="">剪辑状态</option>
                    <option value="0">已剪辑</option>
                    <option value="1">未剪辑</option>
                </select>
            </div>
            <input type="text" name="name" id="name" placeholder="视频名" autocomplete="off" class="layui-input">
            <input type="text" name="videoid" id="videoid" placeholder="视频id" autocomplete="off" class="layui-input">
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

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

</script>
<#--<script>
    function addOptions() {

        $.ajax({
            url: '<%=basePath%>department/findAllDepartment',
            dataType: 'json',
            type: 'post',
            success: function (data) {

                $.each(data, function (index, item) {
                    $('#pname').append(new Option(item.name, item.id));// 下拉菜单里添加元素
                })

                form.render();//下拉菜单渲染 把内容加载进去

            }
        });
    }
</script>-->
<script>
    layui.use('table', function () {
        var table = layui.table;


        //第一个实例
        table.render({
            elem: '#demo'
            , height: 500
            , url: '/youtube/list/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'name', title: '名称', width: 640}
                , {field: 'catid', title: '分类', width: 60}
                , {field: 'videoid', title: '视频ID', width: 120, sort: true}
                , {field: 'createdate', title: '日期', width: 180, templet: '#createdate'}
                , {field: 'isvideoaudio', title: '压制', width: 60,templet: '#isvideoaudioTpl' }
                , {field: 'issubtitle', title: '字幕', width: 60,templet: '#isvideoaudioTpl' }
                , {field: 'isclip', title: '剪辑', width: 60,templet: '#isvideoaudioTpl' }
                , {field: 'issend', title: '发布', width: 60,templet: '#isvideoaudioTpl' }
                , {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器

            ]]
            , id: 'youtubeTable'
        });
        /*reload 表格重载*/
        var $ = layui.$, active = {
            reload: function () {
                var createDate = $('#start');
                var catid = $('#catid');
                var isvideoaudio = $('#isvideoaudio');
                var issubtitle = $('#issubtitle');
                var isclip = $('#isclip');
                var name = $('#name');
                var videoid = $('#videoid');

                //执行重载
                table.reload('youtubeTable', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {//参数
                        //key: {
                        createDate : createDate.val(),
                        catid : catid.val(),
                        isvideoaudio : isvideoaudio.val(),
                        issubtitle : issubtitle.val(),
                        isclip : createDate.val(),
                        name : createDate.val(),
                        videoid : createDate.val()
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
                x_admin_show('查看', '/youtube/get/'+data.id, 600, 400)
            }else if (layEvent === 'edit') {
                x_admin_show('编辑', 'order-edit.html', 600, 600)
            }else if (layEvent === 'del') {
                layer.confirm('真的删除行么00', function (index) {
                    console.log(data);
                    $.ajax({
                        url: "http://localhost:3058/web/uv/delete",
                        type: "POST",
                        data: {"id": data.id},
                        dataType: "json",
                        success: function (data) {
                            console.log(data);
                            if (data == 1) {
                                obj.del();
                                layer.close(index);
                                layer.msg("删除成功", {icon: 6});
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
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

    <!-- 这里同样支持 laytpl 语法，如： -->
    {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  } }}


</script>
<script type="text/html" id="isvideoaudioTpl">
    {{# if(d.isvideoaudio == 0) { }}
    <span class="layui-badge-dot layui-bg-green"></span>
    {{# } else { }}
    <span class="layui-badge-dot layui-bg-orange"></span>
    {{# } }}
</script>
<script type="text/html" id="issubtitleTpl">
    {{# if(d.issubtitle == 0) { }}
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

</body>

</html>