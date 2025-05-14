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
<%@ include file="../common/top.jsp" %>
<h3> 회원 목록 </h3>
<table width=700 border=1>
	<tr>
		<th>아이디		</th>
		<th>비밀번호		</th>
		<th>이름		</th>
		<th>주소		</th>
		<th>전화번호		</th>
		<th>수정/삭제		</th>
	</tr>
	<c:forEach var="item" items="${memberlist}"> 
		<tr>	
			<td><a href="${pageContext.request.contextPath}/view?id=${item.id }">${item.id }</a></td>
			<td>${item.pass }	</td>
			<td>${item.name }		</td>
			<td>${item.addr }		</td>
			<td>${item.tel }		</td>
			<td>수정/삭제		</td>
		</tr>	 
	</c:forEach>	
</table>

</body>
</html>