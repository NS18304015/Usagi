<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css?0">
	<title>掲示板</title>
</head>
<body>
	<div id="header">
		<p style="text-align: left "><a href='indexnew' class="btn-gradient-3d-orange" >TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.jsp' class="btn-gradient-3d-orange">スレッドの作成</a>
		<!-- ↓から -->
		<form method='post' action='kensaku'>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' class="btn-square-so-pop" placeholder='スレッドのタイトルを入力' name='title'><input type='submit' value='検索'>
		</form>
		<!-- ↑まで変更しました（検索のやつ） -->
	</div>
	
	<p>"${titleA}"の検索結果</p>
	
	<%! int count=0; %>
	
	<c:forEach var="prof" items="${users}">
	<% count+=1; %>
	<c:if test="${!(count==0)}">
	<table border="1">
		<tr><th>スレッドNo</th><th>スレッドタイトル</th></tr>
			<tr><td><a href="threadold?tno=${prof.threadno}">${prof.threadno}</a></td><td>${prof.title}</td></tr>
		</table>
			
		</c:if>
		</c:forEach>
		
		<p>検索結果 <b><%=count %></b> 件</p>
		<% count =0; %>
		
		<h1>検索結果並べ替え</h1>	
		<form method='post' action='kensaku'>
			<input type = 'hidden' value=${titleA} name='title' >
			<input type="submit" value="検索結果を新着順で並び替える">
		</form>
		
		<form method='post' action='kensakuold'>
			<input type = 'hidden' value=${titleA} name='title' >
			<input type="submit" value="検索結果を投稿順で並び替える">
		</form>
	
	
</body>
</html>
