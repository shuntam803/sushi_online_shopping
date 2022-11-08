<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- addメソッド作成 --%>
<%!
int add(int a, int b) {
	return a + b;
}
%>
<%-- addメソッドを使ってadd(a, b)のカッコ内に数字を入れる --%>
<p>1 + 2 = <%= add(1, 2) %></p>
<p>3 + 4 = <%= add(3, 4) %></p>

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>