<%@ page pageEncoding="Windows-31J"
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
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.html' class="btn-gradient-3d-orange">スレッドの作成</a>
		<!-- ↓から -->
		<form method='post' action='kensaku'>
			<input type='text' class="btn-square-so-pop" placeholder='スレッドのタイトルを入力' name='title'><input type='submit' value='検索'>
		</form>
		<!-- ↑まで変更しました（検索のやつ） -->
	</div>
	<c:forEach var="prof" items="${users}">
		<h1>タイトル:${prof.title}</h1>
	</c:forEach>
	
	<table border="1">
		<tr><th>レスポンス一覧</th></tr>
		<tr><th>シリアルナンバー</th><th>名前</th><th>コメント</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td>${prof.serialno}</td><td>${prof.name}</td><td>${prof.contents}</td></tr>
		</c:forEach>
	</table>
	
	<h1>返答</h1>
		<form method='post' action='threadnew'>
			<input type='text' placeholder='名前を入力' name='name'><br>
			<input type='text' placeholder="内容" name='contents'><br>
			<input type='submit' value='送信'>
		</form>
	
	
	
</body>
</html>
