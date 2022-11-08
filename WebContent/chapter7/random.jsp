<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- ランダムメソッドを使う --%>
<p><% out.println(Math.random()); %></p>

<p><%= Math.random() %></p>
<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>