<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head><title>�f����</title></head>
<body>
	
	<table border="1">
		<tr><th>�X���b�h�ꗗ</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td>${prof.title}</td><td>${prof.time}</td></tr>
			</tr><td>${prof.contents}</td></tr>
		</c:forEach>
	</table>
	
	<h1>�X���b�h���בւ�</h1>
	<form method = 'get' action = '�T�[�u���b�g��'>
	<a href="#">�l�C��</a>
	</form>
	
	<form method = 'get' action = '�T�[�u���b�g��'>
	<a href="#">�V����</a>
	</form>
	
	<form method = 'get' action = '�T�[�u���b�g��'>
	<a href="#">���e��</a>
	</from>
	
	<a href="#">�g�b�v�֖߂�</a>
	
</body>
</html>
