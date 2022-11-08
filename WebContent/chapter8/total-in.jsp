<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- エラーページの出力(ログイン) --%> 
<strong>数値を入力してください</strong>
<form action="total-out.jsp" method="post">
<input type="text" name="price">円×
<input type="text" name="count">個＝

<input type="submit" value="計算">
</form>

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>