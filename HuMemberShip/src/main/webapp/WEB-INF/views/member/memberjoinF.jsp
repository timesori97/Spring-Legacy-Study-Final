<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script><!--  jquery 설치 -->
<body>
	<%@ include file="../common/top.jsp"%>
	<h3>회원가입</h3>
	<form action="${pageContext.request.contextPath}/memberjoind" method="post" 
	encType="multipart/form-data">  <!--  데이터 베이스에 삽입 작업은 대게 post로 넘긴다. -->
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="userid"><span id="duplexid">중복체크</span></td>
			</tr>
			<script>
			// jquery라는 js라이러브러리  : js의 자주 사용되는 기능으로 개발된 라이브러리
			// 설치는 주로 cnd방식으로 합니다. 
			// jquer문법은 $로 시작합니다.
			$("#duplexid").click(()=>{  // id가 userid인 태그를 선택해서 click이벤트를 정의한다
				let uid = $("#userid").val(); // 아이디로 지정한 곳의 갑을 가져옴
				alert(uid)
				//비동기 통신으로 서버에 전송해 보겠습니다. 
				// request(비동기)  url, parameter, method
				$.ajax({
					async:true,    // false라고 하면 동기방식으로 설정.
					url: "duplexid",  //url된다. 
					data: {
						'id': uid  //  키   : 값
					},
					type : 'GET',   //get방식으로 보내겠다.
					dataType: "text",
					success : function(data){ // data 서버로 부터 받은 데이터를 저장..
						alert(data +" 서버로 부터 받음")
						if(data == ''){
							alert("중복된 아이디입니다.")
							$("#userid").val('');  // 아이디로 지정한 곳에 값을 변경
							$("#userid").focus();							
						}else{
							alert("사용가능")
							$("#duplexid").text(data+' 사용 가능 아이디')
						}
					},
					error : function(){
						alert("통신오류")
					}				
				})				
			})
			</script>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>