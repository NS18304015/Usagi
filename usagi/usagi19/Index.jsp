<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head><title>掲示板</title></head>
<body>
	
	<table border="1">
		<tr><th>スレッド一覧</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td>${prof.title}</td><td>${prof.time}</td></tr>
			</tr><td>${prof.contents}</td></tr>
		</c:forEach>
	</table>
	
	<h1>スレッド並べ替え</h1>
	<a href="#" onclick="サーブレットの処理のリンク">人気順</a>
	<a href="#" onclick="サーブレットの処理のリンク">新着順</a>
	<a href="#" onclick="サーブレットの処理のリンク">投稿順</a>
	
	<a href="#">トップへ戻る</a>
	
</body>
</html>
