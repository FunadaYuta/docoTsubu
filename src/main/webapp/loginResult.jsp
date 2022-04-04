<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Mutter,model.User,model.Thread,java.util.List"  %>
    <% 
    	User loginUser = (User)session.getAttribute("loginUser");
    
   		List<Thread> threadList = (List<Thread>)application.getAttribute("threadList");
		
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おふなの掲示板</title>
</head>
<body>
<h1>おふなですけど</h1>
<% if(loginUser != null){ %>
<p>ログインに成功しました</p>
<p>
ようこそ<%= loginUser.getName() %>さん
<a href="/docoTsubu/CreateThread">スレッドを立てる</a>
</p>
<% if(threadList != null){ %>
<% int count = 0; %>
<% for(Thread thread : threadList){ %>
<p><a href="/docoTsubu/Main?index=<%= count %>"><%= thread.getThreadName()%>(<%= thread.getMutterList().size() %>)</a>
(最終更新日時<%= thread.getMutterList().get(thread.getMutterList().size()-1).getDate() %>)</p>
<% count++; %>
<%} %>
<%} %>

<a href="/docoTsubu/">TOPへ</a>
<%}else{%>
<p>ログインに失敗しましたよ</p>
<a href="/docoTsubu/">TOPへ</a>
<%} %>
</body>
</html>