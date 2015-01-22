<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="noticeList.do?pageNo=1">首页</a></li>
    <li><a href="#">修改公告</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>公告信息</span></div>
    <form action="modifyNotice.do" method="post">
	    <ul class="forminfo">
	    <li><label></label><input name="notice_id" type="hidden" class="dfinput" value="${page.conditions.notice_id }"/></li>
	    <li><label>公告标题</label><input name="title" type="text" class="dfinput" value="${page.conditions.title }"/><i>标题不能超过30个字符</i></li>
	    <li><label>开放人员</label><input name="limit_user" type="text" class="dfinput" value="${page.conditions.limit_user }"/><i>多个关键字用,隔开</i></li>
	    <li><label>公告内容</label><textarea name="context" cols="" rows="" class="textinput" >${page.conditions.context }</textarea></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    
    </div>


</body>

</html>
