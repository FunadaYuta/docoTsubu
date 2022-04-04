<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.Mutter,model.User,model.Thread,java.util.List" %>
    <% 
    User loginUser = (User)session.getAttribute("loginUser");
    
  //リクエストスコープに保存されたエラーメッセージを取得
    String errorMsg = (String)request.getAttribute("errorMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド作成</title>
</head>
<body>
	<form action="/docoTsubu/CreateThread" method="post">
	タイトル:<input type="text" name="threadName"><br>
	名前:<%= loginUser.getName() %><br>
	内容:<br><textarea name=text rows="4" cols="40"></textarea>
	<button type="submit">スレッド作成</button>
	</form>
	<% if(errorMsg != null){ %>
	<p><font color="#ff0000">※<%= errorMsg %></font></p>
	<%} %>
</body>
</html>