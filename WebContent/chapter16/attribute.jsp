<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- pageインポートでbean.productを呼び出す -->
<%@ page import="bean.Product" %>    
<%@ include file="../header.html" %>

<!-- getAttributeメソッドを使ってサーブレットで設定した商品のBeanを取得する
     getAttributeメソッドの戻り値はObject型なのでProduct型に変換する -->
<% Product prod = (Product)request.getAttribute("product"); %>
<!-- JSPの式を用いて「商品番号：商品名：価格」の形式で商品情報を表示する -->
<%= prod.getId() %>:<%= prod.getName() %>:<%= prod.getPrice() %><br>

<%@ include file="../footer.html" %>