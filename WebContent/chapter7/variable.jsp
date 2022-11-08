<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- 変数countAを定義と宣言 --%>
<%! int countA = 0; %>
<%-- 変数countBの定義を宣言(スクリプトレット内) --%>
<%
	int countB = 0;
	countA++;
	countB++;
%>
<%-- addメソッドを使ってadd(a, b)のカッコ内に数字を入れる --%>
<p>宣言による変数countAは<%= countA %></p>
<p>スクリプトレット内の変数countBは<%= countB %></p>

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>