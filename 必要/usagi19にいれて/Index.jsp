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
			<tr><td><a href="Thread.jsp">${prof.no}</a></td><td>${prof.title}</td><td>${prof.name}</td><td>${prof.contents}</td></tr>
		</c:forEach>
	</table>
	
	<h1>スレッド並べ替え</h1>
	<a href="indexgood">人気順</a>
	</form>
	
	<a href="indexnew">新着順</a>
	
	<a href="indexold">投稿順</a>
	
	<a href="create.html">トップへ戻る</a>
	
</body>
</html>
