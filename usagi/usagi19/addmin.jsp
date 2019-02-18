<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>�Ǘ��҃y�[�W</title></head>
<body>
	
	<h1>�񍐃��X�ꗗ</h1>
	<table border="1">
		<c:forEach var="prof" items="${res}">
			<tr><td>${prof.title}</td><td>${prof.name}</td><td>${prof.restime}</td></tr>
			<tr><td>${prof.contents}</td><td>${prof.resreport}</td></tr>
			<form method = 'post' action = '/addmin'>
				<button name="resnum" value=<%= "${prof.resno}" %>>�폜</button>
			</form>
		</c:forEach>
	</table>
	
	<br><br>
	<h1>�񍐃X���b�h�ꗗ</h1>
	<table border="1">
		<c:forEach var="prof" items="${thread}">
			<tr><td>${prof.title}</td><td>${prof.time}</td><td>${prof.threadreport}</td></tr>
			<form method = 'post' action = '/addmin'>
				<button name="threadnum" value=<%="${prof.threadno}"%>>�폜</button>
			</form>
		</c:forEach>
	</table>
	
</body>
</html>
