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
	<div class="container my-3" align="center">
			<div class="col-4">
			<h3>Please Log In</h3>
			<form action="/processLogin.do" method="post">
				<div class="form-group my-3">
					<input type="text" name="mid" class="form-control"
					       placeholder="ID" required autofocus>
				</div>
				<div class="form-group my-3">
					<input type="password" name="passwd" class="form-control"
					       placeholder="Password" required>
				</div>
				<div class="d-grid">
				  <button class="btn btn-success" type="submit">로그인</button>
				</div>
			</form>
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>