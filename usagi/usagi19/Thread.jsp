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
			<title>${prof.time}</title>
	</head>
	   <script>
       </script>

<body>

<div id="header">
		<p style="text-align: right"><a href='test.html' class="btn-gradient-3d-orange">TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.html'  class="btn-gradient-3d-orange">スレッドの作成</a>
		<input type='text' size='40'  placeholder='スレッドのタイトルを入力' name='title'><a href="#" class="btn-square-so-pop">検索</a>　　　　　　　　　</p>
		<form method='post' action='mahiro'>
		</form>
	</div>
<CENTER>
<table border="1">	
	<c:forEach var="i" begin="1" end="5" step="1">
		
		<tr><th><c:out value="${i}" />.${prof.name}&nbsp;&nbsp;${prof.time}<br>${prof.contents}<button id="btn_action">返信</button>
</th></tr><br>
	</c:forEach>
</table>
</CENTER>

 
<!--ダイアログの内容-->
<!--${Provisional.Response_ParentNo}は仮のものです-->
<div id="mydialog" title="返信">
	<form>
	  	<input type='text' placeholder="名前" name='name' required><br>
		<p>
			<textarea name="area1"placeholder='内容を入力' style="width:200px;
			 height:100px;" cols="40" rows="8">&gt;&gt;${Provisional.Response_ParentNo}required</textarea>
		</p><br>
		<input type='submit' value='送信'>
	</form>
</div>


</body>
</html>


