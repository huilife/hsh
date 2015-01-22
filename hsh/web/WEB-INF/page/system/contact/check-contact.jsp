<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公告</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="<%=basePath %>js/date/jquery-date.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<style type="text/css">
	#title{
		font-size:32px;
	}
	#context{
		font-size:16px;
	}
	.ti{
		font-size:10px;
	}
	.place{
		height:40px;
		background:url(../images/righttop.gif) repeat-x;
	}
	.p{
		text-align:right;
		font-size:10px;
	}
	.ss{
		font-size:16px;
	}
	.right{width:300px;height:25px;float:right;border:0px solid red;}
	.right1{width:180px;height:25px;float:right;border:0px solid red;}
	
</style>

</head>

<body background="<%=basePath %>images/notice/contact_bg.jpg">
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="noticeList.do?pageNo=1">网站管理</a></li>
		    <li><a href="#">留言详情</a></li>
	    </ul>
    </div>
    		<br/><br/><br/><br />
    		<p id="context">&nbsp;&nbsp;&nbsp;&nbsp;联系人：${page.conditions.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系方式：${page.conditions.contact }</p>
    		<div id="context">&nbsp;&nbsp;&nbsp;&nbsp;${page.conditions.context }</div><br />
    		<div class="right"><fmt:formatDate  value='${page.conditions.add_time }' pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;</div><br /><br />
    		<div class="right1"></div><p class="p"><a href="checkContact.do?id=${page.theLastObject }" class="ss">上一条</a>&nbsp;|&nbsp;<a href="checkContact.do?id=${page.theNextObject}" class="ss">下一条</a></p>
</body>
</html>
