<%@ page import="java.util.Calendar,
		java.util.Date,
		java.text.SimpleDateFormat"
	pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>掲示板</title>
</head>
<body>

	
	
	<div id="header">
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.jsp' class="btn-gradient-3d-orange">スレッドの作成</a>
		<!-- ↓から -->
		<form method='post' action='kensaku'>
			<input type='text' class="btn-square-so-pop" placeholder='スレッドのタイトルを入力' name='title'><input type='submit' value='検索'>
		</form>
		<!-- ↑まで変更しました（検索のやつ） -->
	</div>
	
	<table border="1">
		<tr><th>スレッド一覧</th><th>タイトル</th><th>名前</th><th>内容</th><th>投稿時間</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td><a href="threadnew?tno=${prof.threadno}">${prof.threadno}</a></td>
			<td>${prof.title}</td><td>${prof.name}</td><td>${prof.contents}</td><td>${prof.time}</td>
			<td>
			<form method='post' action='indexnew'>
				<button name="report" value="${prof.threadno}">報告</button>
			</form>
			</td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>スレッド並べ替え</h1>
	<a href="indexgood">人気順</a>
	</form>
	
	<a href="indexnew">新着順</a>
	
	<a href="indexold">投稿順</a>
	
	
	
</body>
</html>
