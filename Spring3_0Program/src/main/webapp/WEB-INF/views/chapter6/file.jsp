<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="fileUpload.do" method="post" enctype="multipart/form-data">
		학번 : <input type="text" name="studentNumber"> <br>
		리포트파일 : <input type="file" name="report"> <br>
		<input type="submit">
	</form>
</body>
</html>