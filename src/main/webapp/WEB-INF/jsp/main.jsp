<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User,model.Mutter,model.Thread,java.util.List" %>
    <%
    User loginUser = (User)session.getAttribute("loginUser");
    
    /*List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");*/
    List<Thread> threadList = (List<Thread>)application.getAttribute("threadList");
    //リクエストスコープに保存されたエラーメッセージを取得
    String errorMsg = (String)request.getAttribute("errorMsg");
    
    int index = (int)session.getAttribute("index");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おふなの掲示板</title>
</head>
<body>
<h1>メインページ</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="/docoTsubu/Logout">ログアウト</a>
</p>
<p>
<a href="/docoTsubu/Main">更新</a>
<a href="/docoTsubu/loginResult.jsp">戻る</a>
</p>
<form action="/docoTsubu/Main?<%= index %>" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null){ %>
<p><font color="#ff0000">※<%= errorMsg %></font></p>
<%} %>
<% int count = 0; %>
<% for(Mutter mutter : threadList.get(index).getMutterList()){ %>
<% count++;%>
<p><%= count %>  名前：<%= mutter.getUserName() %> <%= mutter.getDate() %><br>
&emsp; <%= mutter.getText() %><br>
<%} %>
</body>
</html>