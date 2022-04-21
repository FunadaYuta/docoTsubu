<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common.jsp" %>
    <%
    
    /*List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");*/
    
    //リクエストスコープに保存されたエラーメッセージを取得
    String errorMsg = (String)request.getAttribute("errorMsg");
    
    int index = (int)session.getAttribute("index");
    
    Thread thread = threadList.get(index);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= thread.getThreadName() %></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
</head>
<body>
<header>
<jsp:include page="/footer.jsp"/>
</header>


<h1 class="h1"><%= thread.getThreadName() %></h1>

<p>

<!-- コメント入力フォームに飛ばす -->
<button type="button" onclick="location.href='#commentForm'">コメントを投稿</button>

<a href="/docoTsubu/Main?index=<%= index %>">更新</a>
<a href="/docoTsubu/loginResult.jsp">戻る</a>
</p>

<% int count = 0; %>
<% for(Mutter mutter : thread.getMutterList()){ %>
<c:set var="String"><%= mutter.getText() %></c:set>
<% count++;%>
<%= count %>  名前：<%= mutter.getUserName() %>(<%= mutter.getAge() %>) <%= mutter.getDate() %>
<p class="mutter-text"><c:out value="${String }"/></p>

<%} %>

<hr>

コメントを投稿する<br>
<!-- 入力フォーム -->

名前:<%= loginUser.getName() %>(<%= loginUser.getAge() %>)<br>
内容:
<form id="Form" class="form" action="/docoTsubu/Main?<%= index %>" method="post">
<textarea id="commentForm" class="text" name="text" rows="4" cols="40" maxlength="255"></textarea>
<input type="submit" value="つぶやく">
</form>

<% if(errorMsg != null){ %>
<p><font color="#ff0000">※<%= errorMsg %></font></p>
<%} %>

<hr>
<!-- スレッド一覧 -->
<footer>
<jsp:include page="/threadList.jsp"/>

</footer>



</body>
</html>