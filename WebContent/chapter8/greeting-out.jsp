<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- 入力用のJSPファイルの作成(ログアウト) --%> 
<% request.setCharacterEncoding("UTF-8"); %>
<p>こんにちは、<%=request.getParameter("user") %>さん！</p>

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>