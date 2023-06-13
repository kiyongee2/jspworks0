<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="container">
		<section id="board_detail">
			<h2>게시글 상세 보기</h2>
			<table>
				<tbody>
					<tr>
						<td>
							<input type="text" name="title" 
									value="${board.title}" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td>
							<textarea rows="8" cols="100"
								readonly="readonly">${board.content}</textarea> 
						</td>
					</tr>
					<tr>
						<td>
							<c:out value="글쓴이: ${board.memberId}" />
								(작성일: <fmt:formatDate value="${board.regDate}" 
										pattern="yyyy-MM-dd hh:mm:ss" />)
						</td>
					</tr>
					<tr>
						<td>
							<a href="/boardList.do">
								<button type="button">목록</button>
							</a>
							<button type="button">수정</button>
							<button type="button">삭제</button>
						</td>
					</tr>
				</tbody>
			</table>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>