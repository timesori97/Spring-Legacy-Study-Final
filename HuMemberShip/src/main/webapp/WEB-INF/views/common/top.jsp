<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
ul li {
	display: inline-block;
	width: 100px;
}
</style>
<body>
	<header>
		<h3>휴먼 홈페이지</h3>
	</header>
	<nav>
		<ul>
			<li>공부방</li>
			<li><a href="${pageContext.request.contextPath}/bbslist">
					자유게시판</a></li>
			<li>QandA</li>
			<li><a href="${pageContext.request.contextPath}/memberjoin">
					회원가입</a></li>
			<li><a href="${pageContext.request.contextPath}/wrf">글쓰기</a></li>
			<li><a href="${pageContext.request.contextPath}/allmember">회원전체보기</a>
		</ul>
	</nav>
	<div>
		<c:if test="${userid == null }">
			<form action="login" method="post">
				id <input type="text" name="id"> pass <input type="password"
					name="pass"> <input type="submit" value="login">
			</form>
		</c:if>
		<c:if test="${userid != null }">
			<span>${userid } 님 로그인</span>
			<span>    <a href="logout"> [로그아웃] </a></span>
		</c:if>
	</div>
	<hr>
</body>
</html>