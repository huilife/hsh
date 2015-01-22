<%@page import="gyt.system.model.UserInfo"%>
<%@page import="gyt.system.model.MenuInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<MenuInfo> menulist = ((UserInfo)session.getAttribute("userinfo")).getMemuList(); 
MenuInfo menu = null;
int menuId = Integer.parseInt(request.getAttribute("menuId")+"");
for(MenuInfo itemmenu : menulist){
	if(itemmenu.getMenuId() == menuId){
		menu = itemmenu;
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span><%=menu.getMenuName() %></div>
    <dl class="leftmenu">
    <%
    	for(int i=0;i<menu.getItemMenuList().size();i++){
    		 MenuInfo item = menu.getItemMenuList().get(i);
    	%>
    		<dd>
    		<div class="title">
		    <span><img src="<%=basePath+item.getImage() %>" /></span><%=item.getMenuName() %>
		    </div>
		    <ul class="menuson">
		    	<%
			    	for(int j=0;j<item.getItemMenuList().size();j++){
			    		 MenuInfo itemItem = item.getItemMenuList().get(j);
			    	%>
			    		<li <%if(j==0&&i==0){%>class="active"<%}%> ><cite></cite><a href="<%=basePath+itemItem.getUrl() %>" target="rightFrame"><%=itemItem.getMenuName() %></a><i></i></li>
			    	<%}
			    
			     %>
    		</dd>
    	<%}
     %>
    </dl>
</body>
</html>
