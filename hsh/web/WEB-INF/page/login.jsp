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
<title>慧生活-智慧社区服务平台</title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/cloud.js" type="text/javascript"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});
var msg = "${msg}";  
if(msg != ""){
	alert("温馨提示: "+msg);
}
</script> 
</head>

<body style="background-color:#1c77ac; background-image:url(<%=basePath%>images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
	<div class="logintop">    
	    <span>欢迎进入慧生活智慧社区服务平台</span>    
	    <ul>
	    <li><a href="<%=basePath%>#">回首页</a></li>
	    <li><a href="<%=basePath%>#">帮助</a></li>
	    <li><a href="<%=basePath%>#">关于</a></li>
	    </ul>    
    </div>
    <div class="loginbody">
	    <span class="systemlogo"></span> 
	    <div class="loginbox">
		    <form action="<%=basePath%>user/login.do" method="post">
			    <ul>
			    <li><input name="username" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
			    <li><input name="password" type="password" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
			    <li><input name="" type="submit" class="loginbtn" value="登录"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="<%=basePath%>#">忘记密码？</a></label></li>
			    </ul>
		    </form>
	    </div>
    </div>
    <div class="loginbm">版权所有  2015  <a href="<%=basePath%>">成都盖天亚科技有限公司</a>  </div>
</body>

</html>
