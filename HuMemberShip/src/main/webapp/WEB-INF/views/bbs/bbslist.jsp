<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/top.jsp"%>
	<h3>자유 게시판</h3>
	<table width=700 border=1>
		<tr>
			<th>게시글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>수정/삭제</th>
		</tr>
		<c:forEach var="item" items="${bbslist}">
			<tr>
				<td>${item.no }</td>
				<td>${item.title }</td>
				<td>${item.name }</td>
				<td>${item.wdate }</td>
				<td>${item.cnt }</td>
				<td><a href="mod?no=${item.no }">수정</a>/<a href="del?no=${item.no }">삭제</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=6>
				<c:if test="${pageVO.prev }">
					<a href="bbslist?page=${pageVO.startPage -1}">[이전페이지그룹] </a>
				</c:if> <!--  forEach   리스틀 순회,  아래처럼 시작과 끝을 지정하여 반복하는 사용것. --> 
				<c:forEach
					begin="${pageVO.startPage}" end="${pageVO.endPage }" var="idx">
					<c:if test="${pageVO.page == idx}">[
					</c:if>
					<a href="bbslist?page=${idx}">${idx}</a>
					<c:if test="${pageVO.page == idx}">]
					</c:if>
				</c:forEach> 
				<c:if test="${pageVO.next }">
					<a href="bbslist?page=${pageVO.endPage + 1 }"> [다음페이지그룹]</a>
				</c:if>
			</td>
		</tr>
	</table>

</body>
</html>