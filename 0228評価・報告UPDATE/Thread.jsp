<%@ page pageEncoding="Windows-31J"
	import="java.util.ArrayList"
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
	
	<c:forEach var="prof" begin="0" end="0" step="1" items="${users}">
		<table><tr><th><h1>タイトル:</h1></th><td><h1>${prof.title}</h1></td></tr></table>
	</c:forEach>
	
	<%! int count = 0;%>
	<table border="1">
		<tr><th>レスポンス一覧</th></tr>
		<tr><th>シリアルナンバー</th><th>名前</th><th>コメント</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td>${prof.serialno}</td><td>${prof.name}</td><td>${prof.contents}</td>
			<td><form method='post' action='threadnew?tno=${prof.threadno}'>
			<button name="rating" value="${prof.resno}">評価</button></form></td>
			<td><form method='post' action='threadnew?tno=${prof.threadno}'>
			<button name="report" value="${prof.resno}">報告</button>
			</form></tr>
			
		</c:forEach>
	</table>
	
	<%  count=((ArrayList)request.getAttribute("users")).size();
		count++;
	 %>
	
	<h1>返答</h1>
		<form method='post' action='threadnew?tno=${prof.threadno}'>
			<textarea name="name"placeholder='名前' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<textarea name="contents"placeholder='レスポンスの内容' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<button type='submit' value='<%=count %>' name='serial'>送信</button>
		</form>
	
	
	
</body>
</html>
