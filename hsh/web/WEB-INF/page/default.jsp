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
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jsapi.js"></script>
<script type="text/javascript" src="<%=basePath %>js/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="<%=basePath %>js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.ba-resize.min.js"></script>

<script type="text/javascript">
		gvChartInit();
		jQuery(document).ready(function(){

		jQuery('#myTable5').gvChart({
				chartType: 'PieChart',
				gvSettings: {
					vAxis: {title: 'No of players'},
					hAxis: {title: 'Month'},
					width: 650,
					height: 250
					}
			});
		});
		</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">工作台</a></li>
    </ul>
    </div>
    
    
    <div class="mainbox">
    
    <div class="mainleft">
    
    
    <div class="leftinfo">
    <div class="listtitle"><a href="#" class="more1">更多</a>数据统计</div>
        
    <div class="maintj">  
    <table id='myTable5'>
				<caption>今日活跃统计</caption>
				<thead>
					<tr>
						<th></th>
						<th>用户活跃数</th>
						<th>商家活跃数</th>
						<th>员工活跃数</th>
						<th>Apr</th>
						<th>May</th>
						<th>Jun</th>
						<th>Jul</th>
						<th>Aug</th>
						<th>Sep</th>
						<th>Oct</th>
						<th>Nov</th>
						<th>Dec</th>
					</tr>
				</thead>
					<tbody>
					<tr>
						<th>2010</th>
						<td>125</td>
						<td>185</td>
						<td>327</td>
						<td>359</td>
						<td>376</td>
						<td>398</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>
				</tbody>
			</table>  
    </div>
    </div>
    <!--leftinfo end-->
    
    
    <div class="leftinfos">
    
   
    <div class="infoleft">
    
    <div class="listtitle"><a href="#" class="more1"></a>待办事项</div>    
    <ul class="newlist">
    <li>报修待处理<a href="#" style="color:red">（10）</a>条<b>2014-10-10</b></li>
    <li>房屋托管待审核<a href="#" style="color:red">（1）</a>条<b>2014-10-09</b></li>
    </ul>   
    
    </div>
    
    
    <div class="inforight">
    <div class="listtitle"><a href="#" class="more1">添加</a>常用工具</div>
    
    <ul class="tooli">
    <li><span><img src="<%=basePath %>images/d01.png" /></span><p><a href="#">小区信息资料</a></p></li>
    <li><span><img src="<%=basePath %>images/d02.png" /></span><p><a href="#">编辑</a></p></li>
    <li><span><img src="<%=basePath %>images/d03.png" /></span><p><a href="#">记事本</a></p></li>
    <li><span><img src="<%=basePath %>images/d04.png" /></span><p><a href="#">任务日历</a></p></li>
    <li><span><img src="<%=basePath %>images/d05.png" /></span><p><a href="#">图片管理</a></p></li>
    <li><span><img src="<%=basePath %>images/d06.png" /></span><p><a href="#">交易</a></p></li>
    <li><span><img src="<%=basePath %>images/d07.png" /></span><p><a href="#">档案袋</a></p></li>    
    </ul>
    
    </div>
    
    
    </div>
    
    
    </div>
    <!--mainleft end-->
    
    
    <div class="mainright">
    
    
    <div class="dflist">
    <div class="listtitle"><a href="#" class="more1">更多</a>最新公告</div>    
    <ul class="newlist">
    <li><a href="#">社区组织公益活动</a></li>
    <li><a href="#">社区好人评选活动正在进行</a></li>
    <li><a href="#">关于社区治安，业主告知书</a></li>
    </ul>        
    </div>
    
    <div class="dflist1">
    <div class="listtitle"><a href="#" class="more1">更多</a>信息统计</div>    
    <ul class="newlist">
    <li><i>会员数：</a></i>2535462</li>
    <li><i>文档数：</a></i>5546</li>
    <li><i>普通文章：</a></i>2315</li>
    <li><i>软件：</a></i>1585</li>
    <li><i>评论数：</a></i>5342</li>    
    </ul>        
    </div>
    
    </div>
    <!--mainright end-->
    </div>
</body>
<script type="text/javascript">
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	}
</script>
</html>
