<%@ page import="java.util.Calendar,
		java.util.Date,
		java.text.SimpleDateFormat"
	pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<title>�X���b�h�쐬</title>
	<link rel="stylesheet" type="text/css" href="style.css?0">
</head>
<body>
	<%! String today=null; %>

	<div id="header">
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.jsp' class="btn-gradient-3d-orange">�X���b�h�̍쐬</a>
		<!-- ������ -->
		<form method='post' action='kensaku'>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' class="btn-square-so-pop" placeholder='�X���b�h�̃^�C�g�������' name='title'><input type='submit' value='����'>
		</form>
		<!-- ���܂ŕύX���܂����i�����̂�j -->
	</div>
	<%
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd H:m:s");
		today=formatter.format(date);
		%>
		<br>
		<form method='post' action='indexnew'>
			<textarea name="title"placeholder='�^�C�g��' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<textarea name="name"placeholder='���O' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<textarea name="contents"placeholder='�ꌏ�ڂ̃��X' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>	
			<button type='submit' value='<%=today%>' name='time'>���M</button>
		</form>
</body>
</html>