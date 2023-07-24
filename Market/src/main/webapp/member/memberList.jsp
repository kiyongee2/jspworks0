<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container my-3">
		<h3 class="text-left mx-4 my-4">회원 목록</h3>
		<div>
			<table class="table table-hover">
				<thead>
					<tr class="text-center">
						<th>번호</th><th>아이디</th><th>이름</th><th>가입일</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>