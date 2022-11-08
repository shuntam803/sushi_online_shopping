<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@ page errorPage="total-error.jsp" %>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- 入力用のJSPファイルの作成(ログイン) --%> 
<p>お名前を入力してください。</p>
<form action="greeting-out.jsp" method="post">
<input type="text" name="user">

<input type="submit" value="確定">
</form>

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>