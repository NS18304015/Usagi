<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>管理者ページ</title></head>
<body>
	
	<h1>報告レス一覧</h1>
	<table border="1">
		<c:forEach var="prof" items="${res}">
			<tr><td>${prof.title}</td><td>${prof.name}</td><td>${prof.restime}</td></tr>
			<tr><td>${prof.contents}</td><td>${prof.resreport}</td></tr>
			<form method = 'post' action = '/addmin'>
				<button name="resnum" value=<%= "${prof.resno}" %>>削除</button>
			</form>
		</c:forEach>
	</table>
	
	<br><br>
	<h1>報告スレッド一覧</h1>
	<table border="1">
		<c:forEach var="prof" items="${thread}">
			<tr><td>${prof.title}</td><td>${prof.time}</td><td>${prof.threadreport}</td></tr>
			<form method = 'post' action = '/addmin'>
				<button name="threadnum" value=<%="${prof.threadno}"%>>削除</button>
			</form>
		</c:forEach>
	</table>
	
</body>
</html>
