<%@ page pageEncoding="Windows-31J"
	import="java.util.ArrayList"
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
	
	<c:forEach var="prof" begin="0" end="0" step="1" items="${users}">
		<table><tr><th><h1>�^�C�g��:</h1></th><td><h1>${prof.title}</h1></td></tr></table>
	</c:forEach>
	
	<%! int count = 0;%>
	<table border="1">
		<tr><th>���X�|���X�ꗗ</th></tr>
		<tr><th>�V���A���i���o�[</th><th>���O</th><th>�R�����g</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td>${prof.serialno}</td><td>${prof.name}</td><td>${prof.contents}</td>
			<td><form method='post' action='threadnew?tno=${prof.threadno}'>
			<button name="rating" value="${prof.resno}">�]��</button></form></td>
			<td><form method='post' action='threadnew?tno=${prof.threadno}'>
			<button name="report" value="${prof.resno}">��</button>
			</form></tr>
			
		</c:forEach>
	</table>
	
	<%  count=((ArrayList)request.getAttribute("users")).size();
		count++;
	 %>
	
	<h1>�ԓ�</h1>
		<form method='post' action='threadnew?tno=${prof.threadno}'>
			<textarea name="name"placeholder='���O' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<textarea name="contents"placeholder='���X�|���X�̓��e' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<button type='submit' value='<%=count %>' name='serial'>���M</button>
		</form>
	
	
	
</body>
</html>
