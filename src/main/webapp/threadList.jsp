<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/common.jsp" %>
 <% if(threadList != null){ %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/threadList.css">
<% int count = 0; %>
<h2>スレッド一覧</h2>
<ul class="thread_list">
<% for(Thread thread : threadList){ %>
<li><p><a href="/docoTsubu/Main?index=<%= count %>"><%= thread.getThreadName()%>(<%= thread.getMutterList().size() %>)</a>
(作成者:<%= thread.getMutterList().get(0).getUserName() %> 最終更新日時<%= thread.getMutterList().get(thread.getMutterList().size()-1).getDate() %>)</p></li>
<% count++; %>
<%} %>
</ul>
<%} %>
 
