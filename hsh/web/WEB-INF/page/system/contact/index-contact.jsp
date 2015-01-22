<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected");
		$(this).addClass("selected");
	});	
});

$(function(){
	
	var text = $('.context').text();
	//alert(text);
/* 	for(var i=0;i<text.length;i++){
		//alert(text[1]);
		if(text[i].text()=="发表内容：请输入您想咨询的问题，我们将以最快的速度回答或联系您，谢谢您的支持！"){
		text[i].text("");
		}
	} */
	
	
});	
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="noticeList.do?pageNo=1">首页</a></li>
    <li><a href="#">留言板</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><a href="javascript:modify();" ><span><img src="<%=basePath %>images/t02.png" /></span>查看</a></li>
        </ul>
        
        <ul class="toolbar1">
        <li><span><img src="<%=basePath %>images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th><input name="select" id="btn" onclick="checkAllaction()" type="checkbox"/></th>
    <th>联系人</th>
    <th>联系方式</th>
    <th>发表内容</th>
    <th>发表时间</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${page.dataList}" var="contact">
    <tr>
    <td><input name="message_id" type="checkbox" /></td>
    <td><a href="<%=basePath %>contact/checkContact.do?id=${contact.message_id }"><p>联系人：${contact.name }</p></a></td>
    <td><a href="<%=basePath %>contact/checkContact.do?id=${contact.message_id }"><p>联系方式：${contact.contact }</p></a></td>
    <td><a href="<%=basePath %>contact/checkContact.do?id=${contact.message_id }"><span class="context">内容：${(contact.context.length()>10) ? contact.context.substring(0,10): contact.context }</span></a></td>
    <td><p>时间：<fmt:formatDate value='${contact.add_time }' pattern="yyyy-MM-dd HH:mm:ss"/></p></td>
    </tr>
    </c:forEach>
    
    </tbody>
    
    </table>
    
    
    
    
    
    <form action="<%=basePath %>contact/contactList.do" method="post">
    	<input type="hidden" name="pageNo" id="pageNo" value="${page.pageNo}" />
    </form>
    <div class="pagin">
    	${page.bulidHtml}
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="<%=basePath %>images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="<%=basePath %>images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
</script>
    
</body>

</html>
