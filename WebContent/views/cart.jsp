<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<%@ include file="menu.jsp"%>

<!-- カートの内容を表示するJSP -->
<c:choose>
  <c:when test="${cart.size() > 0}">
    <p>${cart.size()}種類の商品があります。</p>
  </c:when>
  <c:otherwise>
    <p>カートに商品がありません。</p>
  </c:otherwise>
</c:choose>

<table class="table table-bordered">
  <c:forEach var="item" items="${cart}">
    <tr>
      <td>商品${item.product.id}</td>
      <td><img src="../images/product/${item.product.id}.jpg" height="96"></td>
      <td>${item.product.name}</td>
      <td>${item.product.price}円</td>
      <td>${item.count}個</td>
      <td><a href="CartRemove.action?id=${item.product.id}">カートから削除</a></td>

    </tr>

  </c:forEach>
</table>
<%@ include file="../footer.jsp"%>