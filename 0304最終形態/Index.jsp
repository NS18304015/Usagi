<%@ page import="java.util.Calendar,
		java.util.Date,
		java.text.SimpleDateFormat"
	pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css?0">
	<title>掲示板</title>
</head>
<body>

	
	
	<div id="header">
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.jsp' class="btn-gradient-3d-orange">スレッドの作成</a>
		<!-- ↓から -->
		<form method='post' action='kensaku'>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' class="btn-square-so-pop" placeholder='スレッドのタイトルを入力' name='title'><input type='submit' value='検索'>
		</form>
		<!-- ↑まで変更しました（検索のやつ） -->
	</div>
	<br>
	
	<table><tr><th>スレッド一覧</th></tr></table>
	<table border="1">
		<tr><th>タイトル</th><th>名前</th><th>内容</th><th>投稿時間</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr>
			<td align="center"><a href="threadold?tno=${prof.threadno}">${prof.title}</a></td>
			<td align="center">${prof.name}</td>
			<td align="center">${prof.contents}</td>
			<td align="center">${prof.time}</td>
			<td align="center">
			<form method='post' action='indexnew'>
				<button name="report" value="${prof.threadno}">報告</button>
			</form>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table><tr><th>スレッド並べ替え</th></tr></table>
	<a href="indexgood">人気順</a>
	
	
	<a href="indexnew">新着順</a>
	
	<a href="indexold">投稿順</a>
	
	
	
</body>
</html>

