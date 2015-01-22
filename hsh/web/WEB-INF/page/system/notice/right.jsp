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
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="<%=basePath %>images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="<%=basePath %>images/t02.png" /></span>修改</li>
        <li><span><img src="<%=basePath %>images/t03.png" /></span>删除</li>
        <li><span><img src="<%=basePath %>images/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="<%=basePath %>images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="<%=basePath %>images/px.gif" /></i></th>
        <th>标题</th>
        <th>用户</th>
        <th>籍贯</th>
        <th>发布时间</th>
        <th>是否审核</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${noticeInfo}" var="notice">
	        <tr>
	        <td><input name="" type="checkbox" value="" /></td>
	        <td>${notice.notice_id }</td>
	        <td>${notice.title }</td>
	        <td>${notice.rel_user_id }</td>
	        <td>山东济南</td>
	        <td><fmt:formatDate value='${notice.rel_time }' pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td>未审核</td>
	        <td><a href="#" class="tablelink">查看</a>     <a href="toModify.do?id=${notice.notice_id }" class="tablelink">修改</a></td>
	        </tr>
        </c:forEach>
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${page.rows}</i>条记录，当前显示第&nbsp;<i class="blue">${page.current }&nbsp;</i>页</div>
        <ul class="paginList">
        <c:choose>
                	<c:when test="${page.current>1}">
                		<li class="paginItem"><a href="listOperation.do?current=${page.current-1 }"><span class="pagepre"></span></a></li>
                	</c:when>
                	<c:otherwise>
                		<li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
                	</c:otherwise>
                </c:choose>
                <c:forEach begin="1" end="${page.totalPage}" var="p">
                	<c:choose>
                		<c:when test="${p==page.current}">
                			 <li class="paginItem" current><a>${p}</a></li>
                		</c:when>
                		<c:otherwise>
                			<li class="paginItem"><a href="listOperation.do?current=${p }">${p}</a></li>
                		</c:otherwise>
                	</c:choose>
                </c:forEach>
                <c:choose>
                	<c:when test="${page.current<page.totalPage}">
                		<li class="paginItem"><a href="listOperation.do?current=${page.current+1 }"><span class="pagenxt"></span></a></li>
                	</c:when>
                	<c:otherwise>
                		<li class="paginItem"><a><span class="pagenxt"></span></a></li>
                	</c:otherwise>
                </c:choose>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
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
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
    