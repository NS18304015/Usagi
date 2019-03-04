<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css?0">
	<title>管理者ページ</title>
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
	
	
	<h1>報告レス一覧</h1>
	<table border="1">
		<c:forEach var="prof" items="${response}">
			<tr><td align="center">スレッド名：${prof.title}</td><td align="center">スレッドを立てたユーザー：${prof.name}</td><td align="center">レスポンスをした時間：${prof.restime}</td></tr>
			<tr><td align="center">レスポンスの内容：${prof.contents}</td><td align="center">レスポンスが報告された数：${prof.resreport}</td>
				<td align="center"><form method = 'post' action = 'addminprint'>
					<button name="resnum" value="${prof.resno}">削除</button>
				</form></td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	<h1>報告スレッド一覧</h1>
	<table border="1">
		<c:forEach var="prof" items="${thread}">
			<tr><td align="center">スレッド名：${prof.title}</td><td align="center">スレッドが立てられた時間：${prof.time}</td><td align="center">スレッドが報告された数：${prof.threadreport}</td>
				<td align="center"><form method = 'post' action = 'addminprint'>
					<button name="threadnum" value= "${prof.threadno}" >削除</button>
				</form></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
