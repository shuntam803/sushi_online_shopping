<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- pageディレクティブのisErrorPageを使う(暗黙オブジェクトexceptionが使える) --%> 
<%@ page isErrorPage="true"%>
<%@include file="../footer.html"%>

<%-- 入力用のJSPファイルの作成(ログアウト) --%> 
<% request.setCharacterEncoding("UTF-8"); %>
<div style="border-radius:10px; border:4px double #ff6689; font-size: 100%; padding:20px;">
エラー（数値を入力してください）</div>

<p><%= exception %></p>

<%@include file="../footer.html"%>