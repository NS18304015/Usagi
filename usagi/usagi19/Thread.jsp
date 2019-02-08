<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script></script>
<!-- jQuery UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
  integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<!-- この部分にプログラムの内容を記述します -->

<script>
	$(function(){
  // 画面表示時にダイアログが表示されないよう設定
  $("#mydialog").dialog({ autoOpen: false });
 
  // ボタンのクリックイベント
  $("#btn_action").click(function(){
      // ダイアログを表示する
      $("#mydialog").dialog("open");
  });
})

</script>

<html>
	<head>
			<title>スレッド</title>
	</head>
	   <script>
       </script>

<body>

<p>スレッドタイトル<input type="submit" value="投稿"></p>
<table border="1">	
	<c:forEach var="i" begin="1" end="5" step="1">
		
		<tr><th><c:out value="${i}" />.ああああああ<br>aaaaa<input type="submit" value="返信する"></th></tr><br>
	</c:forEach>
</table>

<button id="btn_action">ダイアログ表示</button>
 
<!--ダイアログの内容-->
<div id="mydialog" title="サンプルタイトル">オリジナルダイアログをポップアップ表示するサンプル。</div>

</body>
</html>


