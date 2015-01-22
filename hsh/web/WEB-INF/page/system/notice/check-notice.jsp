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
	#title2{
		text-align:center;
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
	.right1{width:100px;height:25px;float:right;border:0px solid red;}
</style>
<script type="text/javascript">
	
	$(function(){
		//var file = ${page.conditions.file };
		
		//alert(file);
	});
	function download(filename,fileid){
		window.location.href="/OA/file/downFile.do?filename="+encodeURI(encodeURI(filename))+"&fileid="+fileid;
	}
</script>
</head>

<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="noticeList.do?pageNo=1">公告管理</a></li>
		    <li><a href="#">公告详情</a></li>
	    </ul>
    </div>
    		<br/>
    		<p id="title2" class="ti"><span id="title">${page.conditions.title }</span></p>
    		<br/>
    		<div class="right"><fmt:formatDate  value='${page.conditions.rel_time }' pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;阅读(${page.conditions.read_user==null?0:page.conditions.read_user })</div><br /><br />
    		<div id="context">&nbsp;&nbsp;&nbsp;&nbsp;${page.conditions.context }</div><br/>&nbsp;&nbsp;&nbsp;&nbsp;
    		<a class="ss">附件(${page.conditions.filenume }个)</a><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;
    		<c:if test="${page.conditions.filename!=null }">
	    		<c:forEach items="${page.conditions.filename }" var="filename">
	    			${filename }<a href="javascript:download('${filename }','${page.conditions.notice_id }');">下载</a>&nbsp;&nbsp;&nbsp;&nbsp;
	    		</c:forEach>
    		</c:if><br/><br/>
    		<div class="right1"></div><p class="p"><a href="checkNotice1.do?id=${page.theNextObject.notice_id }" class="ss">上一条:${page.theNextObject.title }</a>&nbsp;|&nbsp;<a href="checkNotice1.do?id=${page.theLastObject.notice_id }" class="ss">下一条:${page.theLastObject.title }</a></p>
</body>
</html>
