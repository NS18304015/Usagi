<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script></script>
<!-- jQuery UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
  integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<!-- ���̕����Ƀv���O�����̓��e���L�q���܂� -->

<script>
	$(function(){
  // ��ʕ\�����Ƀ_�C�A���O���\������Ȃ��悤�ݒ�
  $("#mydialog").dialog({ autoOpen: false });
 
  // �{�^���̃N���b�N�C�x���g
  $("#btn_action").click(function(){
      // �_�C�A���O��\������
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
		<p style="text-align: right"><a href='test.html' class="btn-gradient-3d-orange">TOP</a>&nbsp;&nbsp;&nbsp;<a href='create.html'  class="btn-gradient-3d-orange">�X���b�h�̍쐬</a>
		<input type='text' size='40'  placeholder='�X���b�h�̃^�C�g�������' name='title'><a href="#" class="btn-square-so-pop">����</a>�@�@�@�@�@�@�@�@�@</p>
		<form method='post' action='mahiro'>
		</form>
	</div>
<CENTER>
<table border="1">	
	<c:forEach var="i" begin="1" end="5" step="1">
		
		<tr><th><c:out value="${i}" />.${prof.name}&nbsp;&nbsp;${prof.time}<br>${prof.contents}<button id="btn_action">�ԐM</button>
</th></tr><br>
	</c:forEach>
</table>
</CENTER>

 
<!--�_�C�A���O�̓��e-->
<!--${Provisional.Response_ParentNo}�͉��̂��̂ł�-->
<div id="mydialog" title="�ԐM">
	<form>
	  	<input type='text' placeholder="���O" name='name' required><br>
		<p>
			<textarea name="area1"placeholder='���e�����' style="width:200px;
			 height:100px;" cols="40" rows="8">&gt;&gt;${Provisional.Response_ParentNo}required</textarea>
		</p><br>
		<input type='submit' value='���M'>
	</form>
</div>


</body>
</html>


