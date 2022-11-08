<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- メッセージの出力 --%>
<p>Hello!</p>
<p>こんにちは❕</p>

<%
out.println("Hello!");
out.println("こんにちは！");
%>

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>