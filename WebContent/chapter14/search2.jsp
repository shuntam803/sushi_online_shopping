<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<!-- キーワードを入力するためのページ -->
	<p>検索キーワードを入力してください。</p>
	<form action ="search2" method="post">
		<input type="text" name="price">円以下の商品を
		<input type="submit" value="検索">
	</form>

<%@include file="../footer.html" %>