<%@ page import="java.util.Calendar,
		java.util.Date,
		java.text.SimpleDateFormat"
	pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css?0">
	<title>�f����</title>
</head>
<body>

	
	
	<div id="header">
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.jsp' class="btn-gradient-3d-orange">�X���b�h�̍쐬</a>
		<!-- ������ -->
		<form method='post' action='kensaku'>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' class="btn-square-so-pop" placeholder='�X���b�h�̃^�C�g�������' name='title'><input type='submit' value='����'>
		</form>
		<!-- ���܂ŕύX���܂����i�����̂�j -->
	</div>
	<br>
	
	<table><tr><th>�X���b�h�ꗗ</th></tr></table>
	<table border="1">
		<tr><th>�^�C�g��</th><th>���O</th><th>���e</th><th>���e����</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr>
			<td align="center"><a href="threadold?tno=${prof.threadno}">${prof.title}</a></td>
			<td align="center">${prof.name}</td>
			<td align="center">${prof.contents}</td>
			<td align="center">${prof.time}</td>
			<td align="center">
			<form method='post' action='indexnew'>
				<button name="report" value="${prof.threadno}">��</button>
			</form>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table><tr><th>�X���b�h���בւ�</th></tr></table>
	<a href="indexgood">�l�C��</a>
	
	
	<a href="indexnew">�V����</a>
	
	<a href="indexold">���e��</a>
	
	
	
</body>
</html>

