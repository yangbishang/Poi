<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="commons/basePath.jsp"%>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <%--    <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="Bookmark" href="/favicon.ico" >
        <link rel="Shortcut Icon" href="/favicon.ico" />--%>

    <link rel="stylesheet" type="text/css" href="hui/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="hui/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="hui/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="hui/static/h-ui.admin/css/style.css" />

    <title>后台管理系统</title>
</head>
<body>
<nav class="breakcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>&nbsp;首页
    <span class="c-green en">&gt;</span>生成考勤报表
    <a class="btn btn-success radius r"
       style="line-height: 1.6em;margin-top: 3px;"
       href="javascript:location.replace(location.href)"
       title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>

<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray">
    <span class="cl">
      <a class="btn btn-primary radius">

               <i class="Hui-iconfont">&#xe600;</i>&nbsp;生成上月报表 <button onclick="createExcel()">&nbsp;生成&nbsp;</button>

      </a>
    </span>
    <span class="c2">
      <a class="btn btn-success radius">
                <p id="reprtInfo"></p>
      </a>
    </span>
      <%--<button onclick="displayReport()">查询上月报表</button>--%>
      <button ><a href="downloadExcel">下载上月报表</a></button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


        <input id="inputYear" placeholder="年" size="10"><input id="inputMonth" placeholder="月" size="10">
        <button onclick="reportByMonth()">输入年月查询报表</button>
        <button onclick="downloadByMonth()">下载报表</button>
    </div>

    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <td>员工编号</td>
                <td>员工姓名</td>
                <td>员工部门</td>
                <td>打卡次数</td>
                <td>正常打卡次数</td>
                <td>迟到次数</td>
                <td>早退次数</td>
                <td>请假天数(半天)</td>
                <td>批准天数(半天)</td>
            </tr>
            </thead>
            <tbody id="t">


            </tbody>
            <tfoot>
            <tr class="text-c">
                <td>员工编号</td>
                <td>员工姓名</td>
                <td>员工部门</td>
                <td>打卡次数</td>
                <td>正常打卡次数</td>
                <td>迟到次数</td>
                <td>早退次数</td>
                <td>请假天数(半天)</td>
                <td>批准天数(半天)</td>
            </tr>
            </tfoot>

        </table>
    </div>
</div>

<footer class="footer mt-20">
    <div class="container">
        Copyright &copy;2018-2028  YANG YANG.net  All Rights Reserved.
    </div>
</footer>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="hui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="hui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="hui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->



<script src="js/jquery.dataTables.min.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="hui/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
    $(window).on("load",()=>{

        //得到上月报表是否生成的信息
        getReportInfo();
        function getReportInfo(){


            $.ajax({
                type:"post",
                url:"/ygoa/getReportInfo",
                dataType:"json",
                success:function(data){
                    if(data.flag == 0){
                        $('#reprtInfo').html("上月报表未生成，请先生成报表！");
                    }else{
                        $('#reprtInfo').html("上月报表已生成！请直接查看上月报表或下载上月报表。")
                    }
                }
            })
        }

















    })




    function createExcel(){

        $.ajax({
            type:"post",
            url:"/ygoa/createExcel",
            dataType:"json",
            success:function(data){
                if(data.mess == "no"){
                    alert('已完成上月报表生成！');
                }else if(data.mess == "yes"){
                    alert('报表已存在，请问重复生成！');
                }else{
                    alert('生成发生错误！')
                }
            }
        })
    }

    function displayReport(){
        var flag = '<%=session.getAttribute("flag")%>';
        $("#t").children().remove();

            if(flag==0){
                alert('报表未生成,请先生成报表');
                return;
            }
        $.ajax({
            type:"post",
            url:"/ygoa/displayReport",
            dataType:"json",
            success:function (data) {

                var text = ``
                $.each(data.reports,(i,item)=>{
                    text +=`

                        <tr class="text-c">
                            <td >`+item.empno+`</td>
                            <td >`+item.ename+`</td>
                            <td >`+item.deptno+`</td>
                            <td >`+item.clockIn+`</td>
                            <td >`+item.normalClockIn+`</td>
                            <td >`+item.later+`</td>
                            <td >`+item.leaveEarlier+`</td>
                            <td >`+item.leaveTime+`</td>
                            <td >`+item.approvalTime+`</td>
                        </tr>

                    `
                })

                $("#t").append(text);


      /*          // jquery datatable 插件实现分页条件查询
                $(".table-hover").dataTable({
                    language: {
                        url: "js/zh_CN.txt"
                    }
                })*/
            }
        })

    }



    function reportByMonth(){
        $("#t").children().remove();

        var month = $('#inputMonth').val();
        var year = $('#inputYear').val();
        var flag = '<%=session.getAttribute("flag")%>';

        if(flag==0){
            alert('报表未生成,请先生成报表');
            return;
        }

        $.ajax({
            type:"post",
            url:"/ygoa/displayReportByMY?month="+month+"&year="+year,
            dataType:"json",
            success:function (data) {
                var text1 = ``
                $.each(data.reportList,(i,item)=>{
                    text1 +=`

                        <tr class="text-c">
                            <td >`+item.empno+`</td>
                            <td >`+item.ename+`</td>
                            <td >`+item.deptno+`</td>
                            <td >`+item.clockIn+`</td>
                            <td >`+item.normalClockIn+`</td>
                            <td >`+item.later+`</td>
                            <td >`+item.leaveEarlier+`</td>
                            <td >`+item.leaveTime+`</td>
                            <td >`+item.approvalTime+`</td>
                        </tr>

                    `
                })

                $("#t").append(text1)

                // jquery datatable 插件实现分页条件查询
                $(".table-hover").dataTable({
                    retrieve:true,
                    destroy:true,
                    language: {
                        url: "js/zh_CN.txt"
                    }
                })
        }
    })
    }





    function downloadByMonth(){
        var month = $('#inputMonth').val();
        var year = $('#inputYear').val();

        window.location.href="/ygoa/downloadByMonth?month="+month+"&year="+year;

       /* $.ajax({
            type:"post",
            url:"/ygoa/downloadByMonth?month="+month+"&year="+year,
            dataType:"json",
            success:function(data){
               alert('成功！')
            }
        })*/
    }




</script>


</body>
</html>
