<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Product, javax.servlet.http.HttpSession"%>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<p>カートに追加する商品を入力してください。</p>

<form action="cart" method="post">
  <p>
    商品名
    <input type="text" name="name">
    価格
    <input type="text" name="price">
    <input type="submit" formaction="cart-add3" value="追加" >
  </p>
  <p>
    <input type="submit" formaction="cart-dell3" value="クリア">
  </p>
</form>


<% 
@SuppressWarnings("unchecked")
List<Product> cart = (List<Product>)request.getAttribute("cart");
%>

<% if (cart != null) { %>
  <table border="1">
    <tr bgcolor="pink">
      <th>商品名</th>
      <th>価格(円)</th>
    </tr>
    <% for (Product p : cart) { %>
      <tr>
        <td><%=p.getName() %></td>
        <td align="right"><%=p.getPrice() %></td>
      </tr>
    <% } %>
    <tr>
      <th bgcolor="gray">計：<%=request.getAttribute("cnt") %>個</th>
      <th bgcolor="gray" align="right">合計：<%=request.getAttribute("total") %>円</th>
    </tr>
  </table>
<% } %>


<%@ include file="../footer.html"%>