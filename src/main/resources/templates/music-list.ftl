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
        <a href="">素材列表</a>
        <a>
          <cite>音樂列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <div class="layui-input-inline">
            <input type="text" name="content" id="content" placeholder="内容" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="text" name="songname" id="songname" placeholder="歌曲" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="text" name="songauthor" id="songauthor" placeholder="歌手" autocomplete="off" class="layui-input">
        </div>
        <button class="layui-btn" id="layuibtn" data-type="reload">搜索</button>
    </div>
    <table id="demo" lay-filter="ying"></table>
</div>

<script>
    layui.use('table', function () {
        var table = layui.table;


        //第一个实例
        table.render({
            elem: '#demo'
            , height: 500
            , url: '/music/list/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'nickname', title: '昵称', width: 100}
                , {field: 'content', title: '内容', width: 800}
                , {field: 'likedcount', title: '点赞', width: 80, sort: true}
                , {field: 'songname', title: '歌曲', width: 240}
                , {field: 'songauthor', title: '歌手', width: 240}
                , {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器

            ]]
            , id: 'youtubeTable'
        });
        /*reload 表格重载*/
        var $ = layui.$, active = {
            reload: function () {
                var content = $('#content');
                var songname = $('#songname');
                var songauthor = $('#songauthor');

                //执行重载
                table.reload('youtubeTable', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {//参数
                        content : content.val(),
                        songname : songname.val(),
                        songauthor: songauthor.val()
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
                alert(data.content+"\n\n\n\n"+data.songauthor+"《"+data.songname+"》");
                //x_admin_show('查看', '/youtube/get/'+data.id, 600, 400)
            }else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    console.log(data);
                    var obj={"id": data.id};
                    $.ajax({
                        url: "${request.contextPath}/music/update",
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
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

    <!-- 这里同样支持 laytpl 语法，如： -->
    {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  } }}


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