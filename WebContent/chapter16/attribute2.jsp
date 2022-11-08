<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- pageインポートでbean.productとjava.util.Listを呼び出す -->
<%@ page import="bean.Product, java.util.List" %>
<%@ include file="../header.html" %>

<!-- getAttributeメソッドを使ってサーブレットで設定した商品のリストを取得する
     getAttributeメソッドの戻り値はObject型なのでList<Product>型に変換する -->
     
<% 
@SuppressWarnings("unchecked")
List<Product> list = (List<Product>)request.getAttribute("list"); 
%>

<!-- 拡張for文を使って商品のリストを表示する -->
<% for (Product prod : list) { %>
	<%= prod.getId() %>:<%= prod.getName() %>:<%= prod.getPrice() %>
	<br>
	
<% } %>

<%@ include file="../footer.html" %>