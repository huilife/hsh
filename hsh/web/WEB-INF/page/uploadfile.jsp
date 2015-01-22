<%@page pageEncoding="utf-8"%>
<html>
<head></head>
<body>
	<h1>上传文件</h1>
	<!-- 
		上传文件对表单有2点要求：
		1.method="post"
		2.enctype="multipart/form-data"
	 -->
	<form action="/OA/plupload/plupload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="fiters"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>