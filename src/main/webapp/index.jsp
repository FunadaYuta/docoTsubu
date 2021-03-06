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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/index.css">
<title>船田掲示板</title>
</head>
<body>
<h1>船田掲示板</h1>

<!-- リセットボタン -->
<script>
function resetButton() {
  document.loginForm.reset();
}
</script>


<div id="form">
    <p class="form-title">ログイン</p>
    <% if(errorMsg != ""){ %>
    <font color="red"><%= errorMsg %></font>
    <% } %>
     <form name="loginForm" action="/docoTsubu/Login" method="post">
        <p>名前</p>
        <p class=name><input type="text" name="name" /></p>
        <p>パスワード</p>
        <p class="pass"><input type="password" name="pass" /></p>
        <p class="button_wrapper">
        <button class="loginButton" type="button" onclick="resetButton()">リセット</button>
        <button class="loginButton" type="submit">ログイン</button>
        </p>
    </form>
    <br>
    <hr>
    
    まだ会員登録されてない方<br>
    <h5>初めてご利用の方はこちらから新規登録をすると掲示板を使用できるようになります。</h5>

<div class="button_wrapper">
   <button class="loginButton" type="button" onclick="location.href='/docoTsubu/SignUp'">新規登録</button>
</div>
	
    
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/index.js"></script>
</body>
</html>

