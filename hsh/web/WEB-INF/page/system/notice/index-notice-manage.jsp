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
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
/* $(document).ready(function(){
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

}); */
/* 选中值 */
function modify(){
	var arrays = new Array();              //创建一个数组对象
    var items = document.getElementsByName("notice_id");  //获取name为check的一组元素(checkbox)
    for(i=0; i < items.length; i++){  //循环这组数据
        if(items[i].checked){      //判断是否选中
             arrays.push(items[i].value);  //把符合条件的 添加到数组中. push()是javascript数组中的方法.
        }
    }
    if(arrays.length==0){
    	alert("请选中要修改的一条公告！");
    	return;
    }
    if(arrays.length>1){
    	alert("修改请选择一条记录！");
       	return;
    }
    window.location.href="toModifyNotice.do?arrays="+arrays;  
}
function del(){
	var arrays = new Array();              //创建一个数组对象
    var items = document.getElementsByName("notice_id");  //获取name为check的一组元素(checkbox)
    for(i=0; i < items.length; i++){  //循环这组数据
    	if(items[i].checked){      //判断是否选中
        	arrays.push(items[i].value);  //把符合条件的 添加到数组中. push()是javascript数组中的方法.
         }
   	}
   	if(arrays.length==0){
   		alert("请至少选择一条公告！");
   		return;
   	}
    var r = window.confirm("确定删除"+arrays.length+"条公告吗？删除后将不能恢复！");
    if(r){
    	var delIds = "";
    	for(var i=0;i<arrays.length;i++){
    		delIds+=arrays[i]+",";
    	}
    	 window.location.href="deleteNotice.do?delIds="+delIds;
    }
   
}
 function checkAllaction(){
		var btn = document.getElementById("btn");
		var obj;
		if(btn.checked){
			obj=1;
		}else{
			obj=2;
		}
		for(var i=0;i<document.all.length;i++){
			if (document.all(i).type=="checkbox"){ 
				switch(obj) { 
					case 1:document.all(i).checked=true;
					break; //全选
					case 2:document.all(i).checked=false;
					break; //不选
					case 3:{if(document.all(i).checked==true){
					document.all(i).checked=false;
					}else{
						document.all(i).checked=true;
						}
					}
					break; //反选
				} 
			}
		}
	}
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="noticeList.do?pageNo=1">首页</a></li>
    <li><a href="#">公告列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><a href="toAddNotice.do"><span><img src="<%=basePath %>images/t01.png" /></span>发布</a></li>
        <li class="click"><a href="javascript:modify();" ><span><img src="<%=basePath %>images/t02.png" /></span>修改</a></li>
        <li><a href="javascript:del();"><span><img src="<%=basePath %>images/t03.png" /></span>删除</a></li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="<%=basePath %>images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th><input name="select" id="btn" onclick="checkAllaction()" type="checkbox"/>全选</th>
    <th>公告标题</th>
    <th>发布时间</th>
    <th>发布人</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${page.dataList}" var="notice">
    <tr>
    <td><input name="notice_id" type="checkbox" value="${notice.notice_id }" /></td>
    <td><a href="checkNotice1.do?id=${notice.notice_id }">${notice.title }</a></td>
    <td><p>发布时间：<fmt:formatDate value='${notice.rel_time }' pattern="yyyy-MM-dd HH:mm:ss"/></p></td>
    <td>${notice.user_name }</td>
    </tr>
    </c:forEach>
    
    </tbody>
    
    </table>
    
    
    
    
    
    <form action="<%=basePath %>notice/noticeList.do" method="post">
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
