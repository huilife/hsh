<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/SimpleTree.css"/>
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/SimpleTree.js"></script>
<script type="text/javascript">
$(function(){
	$(".st_tree").SimpleTree({
		click:function(a){
			if(!$(a).attr("hasChild"))
				alert($(a).attr("ref"));
		}
	});
});
</script>

</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    	<li><a href="#">用户管理</a></li>
	    	<li><a href="#">部门管理</a></li>
	    </ul>
    </div>
    <div class="tools">
    	<ul class="toolbar">
	        <li class="click"><span><img src="<%=basePath %>images/t01.png" /></span>添加</li>
	        <li class="click"><span><img src="<%=basePath %>images/t02.png" /></span>修改</li>
	        <li><span><img src="<%=basePath %>images/t03.png" /></span>删除</li>
        </ul>
    </div>
	<table border=0 height=600px align=left>
		<tr>
			<td width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
				<div class="st_tree">
					${depHtml}
				</div>
			</td>
			<td width=770px align=center valign=top>
				<table class="imgtable">
				    <thead>
				    <tr>
					    <th width="100px;">选择</th>
					    <th>部门名称</th>
					    <th>部门描述</th>
				    </tr>
				    </thead>
				    <tbody id="depTbody">
				    </tbody>
			    </table>
			</td>
		</tr>
	</table>
</body>
</html>
<script>
function showDep(depId){
	$.ajax({
           type: "GET",
           url: "<%=basePath %>user/subDepList.do",
           data: {'depId':depId},
           contentType: "application/json; charset=utf-8",
           dataType: "json",
           success: function (data) {
               var trhtml = "";
               for(var i=0;i<data.length;i++){
               	 var depInfo = data[i];
               	 if((i+1)%2==0){
               	 	trhtml += '<tr class="odd">';
               	 }else{
               	 	trhtml += '<tr>';
               	 }
                 trhtml += '<td class="imgtd"><input type="checkbox" value="'+depInfo.depId+'" /></td>';
                 trhtml += '<td><a href="#">'+depInfo.depName+'</a><p>ID: 1</p></td><td>'+depInfo.depDec+'</td></tr>';
               	// trhtml += '<td>已启用</td></tr>';
               }
               $("#depTbody").html(trhtml);
           },
           error: function (msg) {
               alert(msg+"sss");
           }
   });
}
showDep(1);
</script>