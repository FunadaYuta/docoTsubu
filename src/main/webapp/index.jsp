<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.invalidate();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/index.css">
<title>おふなの掲示板</title>
</head>
<body>
<div class="login">
	<h1>おふなの掲示板</h1>
    <form action="/docoTsubu/Login" method="post">
    	<input type="text" name="name" placeholder="Username" required="required" />
        <input type="password" name="pass" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">ログイン</button>
    </form>
</div>

</body>
</html>