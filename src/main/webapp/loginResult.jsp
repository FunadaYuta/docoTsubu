<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>船田掲示板</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/loginResult.css">
</head>
<body>


<% if(loginUser != null){ %>

<jsp:include page="/footer.jsp"/>

<h1>メニュー画面</h1>
ようこそ<%= loginUser.getName() %>さん（<%= loginUser.getAge() %>）
<p>
<a href="/docoTsubu/CreateThread">スレッドを立てる</a>
<a href="/docoTsubu/Login">更新</a>
<a href="/docoTsubu/">ログアウト</a>
</p>



<!-- スレッド一覧 -->
<jsp:include page="/threadList.jsp"/>


<%}else{%>
<p>ログインに失敗しましたよ</p>
<a href="/docoTsubu/">TOPへ</a>
<%} %>
</body>
</html>