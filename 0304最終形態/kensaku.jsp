<%@ page pageEncoding="Windows-31J"
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
	
	<p>"${titleA}"�̌�������</p>
	
	<%! int count=0; %>
	
	<c:forEach var="prof" items="${users}">
	<% count+=1; %>
	<c:if test="${!(count==0)}">
	<table border="1">
		<tr><th>�X���b�hNo</th><th>�X���b�h�^�C�g��</th></tr>
			<tr><td><a href="threadold?tno=${prof.threadno}">${prof.threadno}</a></td><td>${prof.title}</td></tr>
		</table>
			
		</c:if>
		</c:forEach>
		
		<p>�������� <b><%=count %></b> ��</p>
		<% count =0; %>
		
		<h1>�������ʕ��בւ�</h1>	
		<form method='post' action='kensaku'>
			<input type = 'hidden' value=${titleA} name='title' >
			<input type="submit" value="�������ʂ�V�����ŕ��ёւ���">
		</form>
		
		<form method='post' action='kensakuold'>
			<input type = 'hidden' value=${titleA} name='title' >
			<input type="submit" value="�������ʂ𓊍e���ŕ��ёւ���">
		</form>
	
	
</body>
</html>
