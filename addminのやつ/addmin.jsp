<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>管理者ページ</title></head>
<body>
	
	<div id="header">
		<a href='indexnew' >TOPへ</a>&nbsp;&nbsp;&nbsp;<a href='create.html'>スレッドの作成</a>
		<form method='post' action=''>
			<input type='text' placeholder='スレッドのタイトルを入力' name='title'><input type='submit' value='検索'>
		</form>
	</div>
	
	
	<h1>報告レス一覧</h1>
	<table border="1">
		<c:forEach var="prof" items="${response}">
			<tr><td>スレッド名：${prof.title}</td><td>スレッドを立てたユーザー：${prof.name}</td><td>レスポンスをした時間：${prof.restime}</td></tr>
			<tr><td>レスポンスの内容：${prof.contents}</td><td>レスポンスが報告された数：${prof.resreport}</td>
				<td><form method = 'post' action = 'addminprint'>
					<button name="resnum" value="${prof.resno}">削除</button>
				</form></td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	<h1>報告スレッド一覧</h1>
	<table border="1">
		<c:forEach var="prof" items="${thread}">
			<tr><td>スレッド名：${prof.title}</td><td>スレッドが立てられた時間：${prof.time}</td><td>スレッドが報告された数：${prof.threadreport}</td>
				<td><form method = 'post' action = 'addminprint'>
					<button name="threadnum" value= "${prof.threadno}" >削除</button>
				</form></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
