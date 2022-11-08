<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- ELの暗黙オブジェクト --%> 
<strong>数値を入力してください</strong>
<form action="el5-2.jsp" method="post">
<input type="text" name="price">円×
<input type="text" name="count">個＋送料
<input type="text" name="delivery">円＝

<input type="submit" value="計算">
</form>

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>