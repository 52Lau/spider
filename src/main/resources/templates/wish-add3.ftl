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
    <style type="text/css">
        .toolbar {
            border: 1px solid #ccc;
        }
        .text {
            border: 1px solid #ccc;
            height: 800;
        }
    </style>
    <![endif]-->
</head>
<body>
<div class="x-body" id="myDiv">
    <form class="layui-form" id="form1" >

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">id</label>
            <div class="layui-input-block">
                <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">需求</label>
            <div class="layui-input-block">
                <div id="editor">
                    ${content.context }
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">分类</label>
        <#--<div class="layui-input-inline">-->
            <div class="layui-input-block">
                <select name="typeid" id="typeid" style="width:178px;" value="">
                    <option value="">请选择</option>
                 <#list categorys as cate>
                    <option value="${cate.catid!}" <#if cate.catid==content.typeid> selected="selected"</#if>  >${cate.catname!}</option>
                 </#list>
                <#-- <#if categorys??>
                     <#list categorys as type>
                 <option

                         <#if content.typeid??>
                             <#if content.typeid==type['catid']>selected</#if>
                         </#if>

                             value="${type['DICTID']!}">${type['DICTNAME']!}</option>
                     </#list>
                 </#if>-->



                </select>
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

<script src="https:////unpkg.com/wangeditor/release/wangEditor.min.js"></script>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer;
    });
</script>

<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')

    editor.create()
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
        var id=$(“#id).val();
        var  typeid=$("#typeid").val();
        var obj={"id":id,"typeid": typeid,"context":editor.txt.html()};
        $.ajax({
            url: "${request.contextPath}/content/update",
            type: "PUT",
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

                    /*layer.msg('玩命卖萌中', function(){
                        layer.close(index);
                        layui.table.reload('youtubeTable',{page:{curr:1}});
                    });*/
                    layer.msg("更新成功", {icon: 6});
                } else {
                    layer.msg("更新失败", {icon: 5});
                }
            }

        });
    }

</script>
<#--<script>
    $(document).ready(function () {
        $.ajax({
            type: "GET",
            url: "/category/get/2",
            success: function (data) {
                //for (var i = 0; i < data.length; i++) {
                for (var i in data) {
                    $("#typeid").append("<option value= '"+data[i].catid +"'>"+data[i].catname+"</option>");
                }

                //alert(data.catname)

                //}
            }
        });
    });
</script>-->
</body>

</html>