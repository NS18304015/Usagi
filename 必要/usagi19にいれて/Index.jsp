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
			<tr><td><a href="Thread.jsp">${prof.no}</a></td><td>${prof.title}</td><td>${prof.name}</td><td>${prof.contents}</td></tr>
		</c:forEach>
	</table>
	
	<h1>�X���b�h���בւ�</h1>
	<a href="indexgood">�l�C��</a>
	</form>
	
	<a href="indexnew">�V����</a>
	
	<a href="indexold">���e��</a>
	
	<a href="create.html">�g�b�v�֖߂�</a>
	
</body>
</html>
