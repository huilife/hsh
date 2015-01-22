<%@page import="gyt.system.model.UserInfo"%>
<%@page import="gyt.system.model.MenuInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<MenuInfo> menulist = ((UserInfo)session.getAttribute("userinfo")).getMemuList();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>慧生活-智慧社区服务平台</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>
<body style="background:url(<%=basePath %>images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="<%=basePath %>main.jsp" target="_parent"><img src="<%=basePath %>images/system/logo.png" title="系统首页" /></a>
    </div>
    <ul class="nav">
    <%for(int i=0;i<menulist.size();i++){
    	MenuInfo menu = menulist.get(i);
    	%>
    	 <li><a href="<%=basePath %>user/fmenu.do?type=left&menuId=<%=menu.getMenuId() %>" target="leftFrame" <%if(i==0){%>class="selected"<%}%>><img src="<%=basePath+menu.getImage() %>" title="<%=menu.getMenuName() %>" /><h2><%=menu.getMenuName() %></h2></a></li>
    	<%
    } %>
    </ul>
    <div class="topright">    
    <ul>
    <li><span><img src="<%=basePath %>images/help.png" title="帮助"  class="helpimg"/></span><a href="<%=basePath %>#">帮助</a></li>
    <li><a href="<%=basePath %>#">关于</a></li>
    <li><a href="<%=basePath %>user/logout.do" target="_parent">注销</a></li>
    </ul>
    <div class="user">
    <span>${userinfo.realName}</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    </div>
</body>
</html>
