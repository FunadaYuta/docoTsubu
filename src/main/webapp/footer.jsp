<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/footer.css">
<% 
String threadNameSearch =(String)request.getAttribute("threadNameSearch"); 
if(threadNameSearch == null){
	threadNameSearch = "";
}
%>
<br>
<!-- スレッド検索  -->
<form action="/docoTsubu/ThreadSearch" method="get" class="search_container" style="text-align:center;">
  <input type="text" name="threadNameSearch" size="30" placeholder="　キーワード検索" value="<%=threadNameSearch%>">
  <input type="submit"  value="&#xf002">
</form>
<br>