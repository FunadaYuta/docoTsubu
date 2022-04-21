<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common.jsp" %>
    <% 
    
  //リクエストスコープに保存されたエラーメッセージを取得
    String errorMsg = (String)request.getAttribute("errorMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド作成</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/createThread.css">
</head>
<body>


<div id="form">
    <p class="form-title">スレッド作成</p>
	<form class="create_thread">
	
	タイトル:<input type="text" name="threadName" maxlength="50"><br>
	名前:<%= loginUser.getName() %>(<%= loginUser.getAge() %>)<br>
	内容:<br><textarea name=text rows="8" cols="55" maxlength="255"></textarea>
	<button type="submit" formaction="/docoTsubu/CreateThread" formmethod="post">スレッド作成</button>
	<button type="submit" formaction="/docoTsubu/Login" formmethod="get">戻る</button>
	</form>
</div>

	<% if(errorMsg != null){ %>
	<p id="errorMsg"><font color="#ff0000">※<%= errorMsg %></font></p>
	<%} %>
	


</body>
</html>