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
			<title>�X���b�h</title>
	</head>
	   <script>
       </script>

<body>

<p>�X���b�h�^�C�g��<input type="submit" value="���e"></p>
<table border="1">	
	<c:forEach var="i" begin="1" end="5" step="1">
		
		<tr><th><c:out value="${i}" />.������������<br>aaaaa<input type="submit" value="�ԐM����"></th></tr><br>
	</c:forEach>
</table>

<button id="btn_action">�_�C�A���O�\��</button>
 
<!--�_�C�A���O�̓��e-->
<div id="mydialog" title="�T���v���^�C�g��">�I���W�i���_�C�A���O���|�b�v�A�b�v�\������T���v���B</div>

</body>
</html>


