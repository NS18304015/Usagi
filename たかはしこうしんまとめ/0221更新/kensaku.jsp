<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>�f����</title>
</head>
<body>
	<div id="header">
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.html' class="btn-gradient-3d-orange">�X���b�h�̍쐬</a>
		<!-- ������ -->
		<form method='post' action='kensaku'>
			<input type='text' class="btn-square-so-pop" placeholder='�X���b�h�̃^�C�g�������' name='title'><input type='submit' value='����'>
		</form>
		<!-- ���܂ŕύX���܂����i�����̂�j -->
	</div>
	
	<table border="1">
		<tr><th>�X���b�h�ꗗ</th><th>�^�C�g��</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td><a href="threadnew?tno=${prof.threadno}">${prof.threadno}</a></td><td>${prof.title}</td></tr>
		</c:forEach>
	</table>
	
	
	
	
	
</body>
</html>
