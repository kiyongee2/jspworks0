<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<h2>회원 목록입니다..</h2>
	<c:forEach var="member" items="${memberList}">
		<p>아이디 : <c:out value="${member.memberId}" />
	</c:forEach>
</body>
</html>