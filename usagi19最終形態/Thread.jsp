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
	<c:forEach var="prof" items="${users}">
		<h1>�^�C�g��:${prof.title}</h1>
	</c:forEach>
	
	<table border="1">
		<tr><th>���X�|���X�ꗗ</th></tr>
		<tr><th>�V���A���i���o�[</th><th>���O</th><th>�R�����g</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td>${prof.serialno}</td><td>${prof.name}</td><td>${prof.contents}</td></tr>
		</c:forEach>
	</table>
	
	<h1>�ԓ�</h1>
		<form method='post' action='threadnew'>
			<input type='text' placeholder='���O�����' name='name'><br>
			<input type='text' placeholder="���e" name='contents'><br>
			<input type='submit' value='���M'>
		</form>
	
	
	
</body>
</html>
