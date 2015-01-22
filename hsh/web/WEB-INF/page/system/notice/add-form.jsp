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
<title>发布公告</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="<%=basePath %>js/date/jquery-date.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/date/jquery-date.js"></script>
<script src="<%=basePath %>js/plupload/plupload.full.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".datetimeinput").datetimepicker({
            //showOn: "button",
            //buttonImage: "./css/images/icon_calendar.gif",
            //buttonImageOnly: true,
            showSecond: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1
        });
    });
	$(function(){
		$('#title').blur(function(){
			if($('#title').val()==""){
				$('#msg1').text("标题不能为空！").css("color","red");
				return false;
			}else{
				$('#msg1').text("ok！").css("color","#006400");
			}
		});
		$('#limit_user').blur(function(){
			if($('#limit_user').val()==""){
				$('#msg2').text("开放人员不能为空！").css("color","red");
				return false;
			}else{
				$('#msg2').text("ok！").css("color","#006400");
			}
			if($('#datetext').val==""){
				$('#datetext').value(new Date());
			}
		});
	});   
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="noticeList.do?pageNo=1">首页</a></li>
    <li><a href="#">公告发布</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>发布信息</span></div>
    <form action="addNotice.do" method="post" enctype="multipart/form-data">
	    <ul class="forminfo">
	    <li><label>公告标题</label><input id="title" name="title" type="text" class="dfinput" /><i id="msg1">标题不能超过30个字符</i></li>
	    <li><label>开放人员</label><input id="limit_user" name="limit_user" type="text" class="dfinput" /><i id="msg2">多个关键字用,隔开</i></li>
	    <li>
	    	<label>发布时间</label>
	    	<input type="text" id="datetext" name="time" class="datetimeinput" readonly="true" value="系统当前时间！" />
	    </li>
	    <li>
	    	<div class="wraper"><label>文件上传</label><input type="button" value="选择文件..." id="browse" />
			<input type="button" value="开始上传" id="upload-btn" />
			<div class="btn-wraper"><ul id="file-list"></ul></div>
			</div>
			</li>
		<%-- <li><label>11<input type="text" name="file" value="${filePath }"/></label></li> --%>
	    <li><label>公告内容</label><textarea name="context" cols="" rows="" class="textinput"></textarea></li>
	    <li><label>&nbsp;</label><input name="" id="submit" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    
    </div>


</body>
<script type="text/javascript">

	var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'browse',
		resize : {width : 320, height : 240, quality : 90},
		url : '/OA/file/uploadFile.do',
		flash_swf_url : 'js/Moxie.swf',
		silverlight_xap_url : 'js/Moxie.xap',
		unique_names : true,
		filters: {
			  mime_types : [ //只允许上传图片和zip文件
			    { title : "Image files", extensions : "jpg,gif,png" }, 
			    { title : "Zip files", extensions : "zip" }
			  ],
			  max_file_size : '50mb', //最大只能上传400kb的文件
			  prevent_duplicates : true //不允许选取重复文件
			}

	});
	uploader.init(); //初始化

	//绑定文件添加进队列事件
	uploader.bind('FilesAdded',function(uploader,files){
		for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			//构造html来更新UI
			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p><p id="progress' + files[i].id +'" class="progress"></p><a id="del'+files[i].id+'" class="del" href="javascript:del(\'file-' + files[i].id +'\');">删除</a></p></li>';
			$(html).appendTo('#file-list');
		}
	});

	//绑定文件上传进度事件
	uploader.bind('UploadProgress',function(uploader,file){
		//alert(file.percent + '%');
		$('#progress'+file.id).html(file.percent + '%');
		//$('#progress'+file.id).css('width',file.percent + '%');//控制进度条
	});

	//上传按钮
	$('#upload-btn').click(function(){
		
		uploader.start(); //开始上传
		$('.del').remove();
	});
	function del(objid){
		//alert(objid);
		//var delObj = $('#'+objid);
		//var file = delObj.parentNode;
		//alert(file);
		//uploader.removeFile(file);
		$('#'+objid).remove();
	}
	</script>
</html>
