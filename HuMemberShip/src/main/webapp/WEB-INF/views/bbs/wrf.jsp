<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/top.jsp" %>
<h3> 글쓰기 화면 </h3>
<form action="saved" method="post" id="frm" encType="multipart/form-data">
	제목 <input type="text" name="title" id='title'>
	작성자<input type="text" name="name" id="name">
	내용<input type="text" name="body">
	비밀글여부<select name="s_flag">
				<option value="y">공개글</option>
				<option value="n">비공개글</option>
	</select>
	<input type="file" name="filename">
	<input type="file" name="filename">
	<input type="button" value="전송" onclick="chk()">
</form>
</body>
</html>
<script>	
	function chk(){
		let id = document.getElementById('name').value;
		let title = document.getElementById('title').value;
		if(id==''){
			alert('이름은 필수'); return;
		}
		if(title==''){
			alert('제목은 필수'); return;
		}
		if(title.length > 20){
			alert('제목은 20글자 미만입니다.'); return;
		}		
		// 여기까지 오면 위 3개의 유효성을 통과한 것이니. 서브밋
		document.getElementById('frm').submit()
	}
</script>