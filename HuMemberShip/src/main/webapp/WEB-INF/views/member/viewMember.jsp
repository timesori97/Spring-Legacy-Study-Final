<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/top.jsp"%>
	<h3>회원정보보기</h3>
		<table border=1>
			<tr>
				<td>아이디</td>
				<td>${member.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${member.pass}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.name}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${member.addr}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${member.tel}</td>
			</tr>
			<tr>
				<td colspan=2>
					<c:forEach var="item" items="${attachList}">
						<a href="/hom/download?filename=${item }">[다운로드]</a>	
						<img src="/hom/download?filename=${item }">	
					</c:forEach>			
				
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="button" value="전체목록보기">
				</td>
			</tr>
		</table>	
</body>
</html>