<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- メッセージの出力 --%>
<p>Hello!</p>
<p>こんにちは❕</p>

<p><% out.println(new java.util.Date()); %></p>
<p><% 
	out.println(new java.text.SimpleDateFormat
			   ("yyyy年 MM月 dd日 hh時 mm分 ss秒").format
			   (new java.util.Date()));
	%>
</p>
<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>