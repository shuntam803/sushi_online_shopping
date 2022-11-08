<%@page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%-- pageディレクティブを使ってimportを読み込み --%>
<%@page import="java.util.Date" import= "java.text.SimpleDateFormat" %>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- メッセージの出力 --%>
<p>Hello!</p>
<p>こんにちは❕</p>

<p><%=new Date()%></p>

<p><%=new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分 ss秒")
				.format(new Date())%></p>
				
<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>