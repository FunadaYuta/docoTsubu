<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
session.invalidate();
String errorMsg = "";
if(request.getAttribute("errorMsg") != null){
	errorMsg = (String)request.getAttribute("errorMsg");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/index.css">
</head>
<body>

<!-- リセットボタン -->
<script>
function resetButton() {
  document.loginForm.reset();
}
</script>

<h1>船田掲示板</h1>

<div id="form">
    <p class="form-title">新規登録</p>
    <% if(errorMsg != ""){ %>
    <font color="red"><%= errorMsg %></font>
    <% } %>
     <form name="loginForm" action="/docoTsubu/SignUp" method="post">
        <p>名前</p>
        <p class=name><input type="text" name="name" /></p>
        <p>パスワード</p>
        <p class="pass"><input type="password" name="pass" /></p>
        <p>年齢</p>
        <p class="age"><input type="text" name="age" /></p><br>
        <p class="button_wrapper">
        <button class="loginButton" type="button" onclick="resetButton()">リセット</button>
        <button class="loginButton" type="submit">新規登録</button>
        </p>
    </form>
    <br>
    <hr>
    
    既に登録を済ませている方<br>
    <h5>既に登録を済ませている方はこちらからログインをすると掲示板を使用できるようになります。</h5>

<div class="button_wrapper">
   <button class="loginButton" type="button" onclick="location.href='/docoTsubu'">ログイン画面へ</button>
</div>

</div>
</body>
</html>