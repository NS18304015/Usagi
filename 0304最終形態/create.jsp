<%@ page import="java.util.Calendar,
		java.util.Date,
		java.text.SimpleDateFormat"
	pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<title>スレッド作成</title>
	<link rel="stylesheet" type="text/css" href="style.css?0">
</head>
<body>
	<%! String today=null; %>

	<div id="header">
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.jsp' class="btn-gradient-3d-orange">スレッドの作成</a>
		<!-- ↓から -->
		<form method='post' action='kensaku'>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' class="btn-square-so-pop" placeholder='スレッドのタイトルを入力' name='title'><input type='submit' value='検索'>
		</form>
		<!-- ↑まで変更しました（検索のやつ） -->
	</div>
	<%
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd H:m:s");
		today=formatter.format(date);
		%>
		<br>
		<form method='post' action='indexnew'>
			<textarea name="title"placeholder='タイトル' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<textarea name="name"placeholder='名前' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<textarea name="contents"placeholder='一件目のレス' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>	
			<button type='submit' value='<%=today%>' name='time'>送信</button>
		</form>
</body>
</html>