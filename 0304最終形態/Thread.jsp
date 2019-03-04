<%@ page pageEncoding="Windows-31J"
	import="java.util.ArrayList,
			java.util.Calendar,
			java.util.Date,
			java.text.SimpleDateFormat"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css?0">
	<title>�f����</title>
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
	
	<br>
	
	<c:forEach var="prof" begin="0" end="0" step="1" items="${users}">
		<table><tr><th><h1>�^�C�g��:</h1></th><td align="center"><h1>${prof.title}</h1></td></tr></table>
	</c:forEach>
	
	<br>
	
	<%! int count = 0;%>
	<%! String threadno ="";%>
	<table><tr><th>���X�|���X�ꗗ</th></tr></table>
	<table border="1">
		
		<tr><th>�V���A���i���o�[</th><th>���O</th><th>�R�����g</th><th>���e����</th></tr>
		<c:forEach var="prof" items="${users}">
			<tr><td align="center">${prof.serialno}</td>
			<td align="center">${prof.name}</td>
			<td align="center">${prof.contents}</td>
			<td align="center">${prof.time}</td>
			<td align="center">
			<form method='post' action='threadold?tno=${prof.threadno}'>
				<button name="rating" value="${prof.resno}">���]��</button>
			</form>
			</td>
			<td align="center">
			<form method='post' action='threadold?tno=${prof.threadno}'>
				<button name="report" value="${prof.resno}">��</button>
			</form></tr>
			
		</c:forEach>
	</table>
	
	<%  count=((ArrayList)request.getAttribute("users")).size();
		count++;
		
	 %>
	 
	<%
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd H:m:s");
		today=formatter.format(date);
	%>
	
	
	<h1>�ԓ�</h1>
		<form method='post' action='threadold?tno=${prof.threadno}'>
			<textarea name="name"placeholder='���O' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<textarea name="contents"placeholder='���X�|���X�̓��e' style="width:600px; height:100px;" cols="40" rows="8" required></textarea><br>
			<input type="hidden" value='<%=today %>' name='today'>
			<button type='submit' value='<%=count %>' name='serial'>���M</button>
		</form>
	
	<br>
	<table><td align="center">���X�|���X���ёւ�</td></table>
		<a href="threadnew?tno=${tno}">�V����</a>
		<a href="threadold?tno=${tno}">���e��</a>
		<a href="threadgood?tno=${tno}">�l�C��</a>

		
	
</body>
</html>
