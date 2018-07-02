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

<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">阳光OA系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">v6.66</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav class="nav navbar-nav">
                <ul class="cl">

                </ul>
            </nav>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li id="type"></li>
                    <li class="dropDown dropDown_hover">
                        <a href="#" class="dropDown_A" id="username"><i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;">个人信息</a></li>
                            <li><a href="javascript:;">修改密码</a></li>

                            <li><a href="#">切换用户</a></li>

                            <li><a href="JavaScript:;">退出</a></li>
                        </ul>
                    </li>

                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <!--

        从这里开始就是菜单了，各位选好自己负责的模块自己定义跳转页面（data-href属性）,记得统一把html后缀改为jsp
        data-href属性值是自己定义的！！！！自带的不算
        data-href属性值是自己定义的！！！！自带的不算
        data-href属性值是自己定义的！！！！自带的不算
        查看H-ui的那些页面，自己选一个放上来自己改，连接过去就是了，名字也自己定义
        里面的具体实现由自己来决定

        -->
        <dl id="menu-articleasdasd">
            <dt><i class="Hui-iconfont">&#xe616;</i> 信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="article-list.html" data-title="个人信息管理及查看" href="javascript:void(0)">个人信息管理及查看</a></li>
                    <li><a data-href="article-list.html" data-title="部门公告查看" href="javascript:void(0)">部门公告查看</a></li>
                    <li><a data-href="article-list.html" data-title="公司公告查看" href="javascript:void(0)">公司公告查看</a></li>
                    <li><a data-href="article-list.html" data-title="公司员工基本信息" href="javascript:void(0)">公司员工基本信息</a></li>
                    <li><a data-href="article-list.html" data-title="部门员工详细信息" href="javascript:void(0)">部门员工详细信息</a></li>
                    <li><a data-href="article-list.html" data-title="发布部门公告" href="javascript:void(0)">发布部门公告</a></li>
                    <li><a data-href="article-list.html" data-title="公司员工详细信息" href="javascript:void(0)">公司员工详细信息</a></li>
                    <li><a data-href="article-list.html" data-title="发布公司公告" href="javascript:void(0)">发布公司公告</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-picture">
            <dt><i class="Hui-iconfont">&#xe647;</i> 考勤管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="picture-list.html" data-title="查看考勤记录" href="javascript:void(0)">查看考勤记录</a></li>
                    <li><a data-href="picture-list.html" data-title="打卡签到" href="javascript:void(0)">打卡签到</a></li>
                    <li><a data-href="picture-list.html" data-title="补卡" href="javascript:void(0)">补卡</a></li>
                    <li><a data-href="picture-list.html" data-title="查看审批记录" href="javascript:void(0)">查看审批记录</a></li>
                </ul>
            </dd>
        </dl>

        <dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe603;</i> 请假管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="product-brand.html" data-title="申请请假" href="javascript:void(0)">申请请假</a></li>
                    <li><a data-href="product-category.html" data-title="查看假期" href="javascript:void(0)">查看假期</a></li>
                    <li><a data-href="product-list.html" data-title="查看审批" href="javascript:void(0)">查看审批</a></li>
                </ul>
            </dd>
        </dl>

        <dl id="menu-comments">
            <dt><i class="Hui-iconfont">&#xe643;</i> 组织管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="http://h-ui.duoshuo.com/admin/" data-title="部门信息管理" href="javascript:;">部门信息管理</a></li>
                    <li><a data-href="feedback-list.html" data-title="公司信息管理" href="javascript:void(0)">公司信息管理</a></li>
                </ul>
            </dd>
        </dl>


        <dl id="menu-member">
            <dt><i class="Hui-iconfont">&#xe60d;</i> 人事管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="member-list.html" data-title="入职分配" href="javascript:;">入职分配</a></li>
                    <li><a data-href="member-del.html" data-title="人事变动" href="javascript:;">人事变动</a></li>
                    <li><a data-href="member-level.html" data-title="离职管理" href="javascript:;">离职管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-admin">
        <dt><i class="Hui-iconfont">&#xe62d;</i> 审批管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
            <ul>
                <li><a data-href="admin-role.html" data-title="请假审批" href="javascript:void(0)">请假审批</a></li>
                <li><a data-href="admin-role.html" data-title="补卡审批" href="javascript:void(0)">补卡审批</a></li>
                <li><a data-href="admin-permission.html" data-title="查看过往审批记录" href="javascript:void(0)">查看过往审批记录</a></li>
            </ul>
        </dd>
    </dl>
        <dl id="menu-tongji">
            <dt><i class="Hui-iconfont">&#xe61a;</i> 假期管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="charts-1.html" data-title="员工假期管理" href="javascript:void(0)">员工假期管理</a></li>
                    <li><a data-href="generateReport.jsp" data-title="生成考勤报表" href="javascript:void(0)">生成考勤报表</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="welcome.html">我的桌面</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="welcome.html"></iframe>
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前 </li>
        <li id="closeall">关闭全部 </li>
    </ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="hui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="hui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="hui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="hui/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">

</script>


</body>
</html>