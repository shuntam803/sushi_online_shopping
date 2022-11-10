<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<%@ include file="menu.jsp"%>

<!-- 購入画面を表示するJSP -->
<p>${cart.size()}種類の商品があります。</p>
<hr>
<div class="container-fluid">
<table class="table table-bordered""text-center">
  <c:forEach var="item" items="${cart}">
    <tr>
      <td>商品${item.product.id}</td>
      <td><img src="../images/product/${product.id}.jpg" height="96"></td>
      <td>${item.product.name}</td>
      <td>${item.product.price}円</td>
      <td>${item.count}個</td>
    </tr>
  </c:forEach>
</table>
<hr>

<form action="Purchase.action" method="post">
  <p>
    お名前 <input type="text" name="name">
  </p>
  <p>
    ご住所 <input type="text" name="address">
  </p>
  <p>
    <input type="submit" value="購入を確定">
  </p>
</form>

<%@ include file="../footer.jsp"%>