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
        <a href="">賬號管理</a>
        <a>
          <cite>賬號信息列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <#--<div class="layui-row">
        <div class="layui-input-inline">
            <input class="layui-input" placeholder="创建时间" name="createdate" id="start">
        </div>
        <div class="layui-input-inline">
            <select name="catid" id="catid" style="height: 40px;">
                <option value="">分类</option>
                <option value="0">科技</option>
                <option value="1">军事</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="isvideoaudio" id="isvideoaudio" style="height: 40px;">
                <option value="">压制状态</option>
                <option value="0">已压制</option>
                <option value="1">未压制</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="issubtitle" id="issubtitle" style="height: 40px;">
                <option value="">字幕状态</option>
                <option value="0">已确认</option>
                <option value="1">待确认</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="isclip" id="isclip" style="height: 40px;">
                <option value="">剪辑状态</option>
                <option value="0">已剪辑</option>
                <option value="1">未剪辑</option>
            </select>
        </div>
        <div class="layui-input-inline">
        <input type="text" name="name" id="name" placeholder="视频名" autocomplete="off" class="layui-input">
        </div>
         <div class="layui-input-inline">
        <input type="text" name="videoid" id="videoid" placeholder="视频id" autocomplete="off" class="layui-input">
        </div>
        <button class="layui-btn" id="layuibtn" data-type="reload">搜索</button>
        &lt;#&ndash;</form>&ndash;&gt;
    </div>-->
    <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./account-add.html',600,400)"><i class="layui-icon"></i>添加</button>
    </xblock>
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
<script>
    layui.use('table', function () {
        var table = layui.table;


        //第一个实例
        table.render({
            elem: '#demo'
            , height: 500
            , url: '/account/list/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'name', title: '昵称', width: 100}
                , {field: 'email', title: '邮箱', width: 100}
                , {field: 'phone', title: '手机', width: 100, sort: true}
                , {field: 'pwd', title: '密码', width: 100, templet: '#pwd'}
                , {field: 'platform', title: '平台', width: 100, templet: '#platformTpl'}
                , {field: 'type', title: '类型', width: 100,templet: '#typeTpl' }
                , {field: 'owner', title: '所属', width: 100,templet: '#ownerTpl' }
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
                alert("pwd:"+data.pwd)
            }else if (layEvent === 'edit') {
                alert("待续")
               /* x_admin_show('编辑', 'order-edit.html', 600, 600)*/
            }else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    console.log(data);
                    var obj={"id": data.id};
                    $.ajax({
                        url: "${request.contextPath}/account/update",
                        type: "DELETE",
                        data: JSON.stringify(obj),
                        dataType: "json",
                        contentType : "application/json",
                        success: function (data) {
                            if (data = 200) {
                                /*layer.close(index);
                                layer.msg("删除成功", {icon: 6});
                                //关闭后的操作
                                location.reload();
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);*/

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
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

    <!-- 这里同样支持 laytpl 语法，如： -->
    {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  } }}


</script>
<script type="text/html" id="pwd">
    <span class="layui-badge-dot layui-bg-orange"></span>
    <span class="layui-badge-dot layui-bg-orange"></span>
    <span class="layui-badge-dot layui-bg-orange"></span>
    <span class="layui-badge-dot layui-bg-orange"></span>
    <span class="layui-badge-dot layui-bg-orange"></span>
    <span class="layui-badge-dot layui-bg-orange"></span>
</script>
<script type="text/html" id="platformTpl">
    {{# if(d.platform ==0 ) { }}
    <span class="layui-badge layui-bg-orange">企鹅号</span>
    {{# } else if(d.platform ==1 ){ }}
    <span class="layui-badge layui-bg-green">大鱼号</span>
    {{# } else if(d.platform ==2 ){ }}
    <span class="layui-badge layui-bg-green">一点号</span>
    {{# } else if(d.platform ==3 ){ }}
    <span class="layui-badge layui-bg-green">百家号</span>
    {{# } else { }}
    <span class="layui-badge layui-bg-blue">东方号</span>
    {{# } }}
</script>

<script type="text/html" id="typeTpl">
    {{# if(d.type ==0 ) { }}
    <span class="layui-badge layui-bg-orange">Music</span>
    {{# } else if(d.type ==1 ){ }}
    <span class="layui-badge layui-bg-green">Youtube</span>
    {{# } else if(d.type ==2 ){ }}
    <span class="layui-badge layui-bg-green">History</span>
    {{# } else { }}
    <span class="layui-badge layui-bg-blue">未知</span>
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