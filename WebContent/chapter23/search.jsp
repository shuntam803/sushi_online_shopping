<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<!-- キーワードを入力するためのページ -->
<p>検索キーワードを入力してください。</p>

<form action="Search.action" method="post">
  <input type="text" name="keyword" value="${param.keyword}">
  <input type="submit" value="検索">
  <br><input type="submit" value="追加画面" formaction="insert.jsp">
</form>



<%@ include file="../footer.html" %>