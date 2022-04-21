<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common.jsp" %>
    <%	    
    //検索結果の文字を格納する
    String threadNameSearch =(String)request.getAttribute("threadNameSearch");
    
    List<Thread> threadResult = new ArrayList<Thread>();
  
    //スレッドがあるかないか
    String errorMsg = null;
    if(threadList == null){
		errorMsg = (String)request.getAttribute("errorMsg");
    }else{
    	        
    	//検索に引っかかったスレッドをThreadResultに格納する
    	for(Thread thread : threadList){
    		String threadName = thread.getThreadName();
    		boolean bool = threadName.contains(threadNameSearch);
    		if(bool){
    			threadResult.add(thread);
    		}
    	}	    	
    }
    
 	//検索結果が０もしくはスレッドがなかった場合
	if(threadResult.size() == 0){
		threadResult = null;
	}
    

    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>船田掲示板スレッド検索</title>
</head>
<body>

<jsp:include page="/footer.jsp"/>

<% if(threadResult != null){ %>
<% int count = 0; %>
<% for(Thread thread : threadResult){ %>
<p><a href="/docoTsubu/Main?index=<%= count %>"><%= thread.getThreadName()%>(<%= thread.getMutterList().size() %>)</a>
(最終更新日時<%= thread.getMutterList().get(thread.getMutterList().size()-1).getDate() %>)</p>
<% count++; %>
<% }%>
<a href="/docoTsubu/Login">戻る</a>
<% }else{ %>
<div>
<b><%= threadNameSearch %></b>に関するスレッドは見つかりませんでした。
<a href="/docoTsubu/Login">戻る</a><br>

<!-- スレッドが一つもない場合 -->
<% if(errorMsg != null){%>
	<%= errorMsg %>
	<a href="/docoTsubu/CreateThread">スレッドを立てる</a><br>
<% }else{ %>
	
<p>検索のヒント:</p>
<ul>	
  <li>キーワードに誤字・脱字がないか確認します。</li>
  <li>別のキーワードを試してみます。</li>
  <li>もっと一般的なキーワードに変えてみます。</li>
</ul>

<% }} %>
</div>
</body>
</html>