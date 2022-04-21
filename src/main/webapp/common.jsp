<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.Mutter,model.Thread,model.Account,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
Account loginUser = (Account)session.getAttribute("loginUser");
List<Thread> threadList = (List<Thread>)application.getAttribute("threadList");
%>