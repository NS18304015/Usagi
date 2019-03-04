<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css?0">
	<title>�Ǘ��҃y�[�W</title>
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
	
	
	<h1>�񍐃��X�ꗗ</h1>
	<table border="1">
		<c:forEach var="prof" items="${response}">
			<tr><td align="center">�X���b�h���F${prof.title}</td><td align="center">�X���b�h�𗧂Ă����[�U�[�F${prof.name}</td><td align="center">���X�|���X���������ԁF${prof.restime}</td></tr>
			<tr><td align="center">���X�|���X�̓��e�F${prof.contents}</td><td align="center">���X�|���X���񍐂��ꂽ���F${prof.resreport}</td>
				<td align="center"><form method = 'post' action = 'addminprint'>
					<button name="resnum" value="${prof.resno}">�폜</button>
				</form></td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	<h1>�񍐃X���b�h�ꗗ</h1>
	<table border="1">
		<c:forEach var="prof" items="${thread}">
			<tr><td align="center">�X���b�h���F${prof.title}</td><td align="center">�X���b�h�����Ă�ꂽ���ԁF${prof.time}</td><td align="center">�X���b�h���񍐂��ꂽ���F${prof.threadreport}</td>
				<td align="center"><form method = 'post' action = 'addminprint'>
					<button name="threadnum" value= "${prof.threadno}" >�폜</button>
				</form></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
