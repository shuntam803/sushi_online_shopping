<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>


<%@ page import="java.text.SimpleDateFormat"%>


<p>
  <%
  out.println(new java.text.SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒").format(new java.util.Date()));
  %>
</p>

<!-- メニュー画面 -->

  <thead style="text-align: right">
    <tr>
      <th><a href="../chapter25/Product.action">商品</a></th>
      <th><a href="../chapter25/cart.jsp">カート</a></th>
      <th><a href="../chapter25/Preview.action">購入</a></th>
      <th><a href="../chapter24/login-in.jsp">ログイン</a></th>
      <th><a href="../chapter24/logout-in.jsp">ログアウト</a></th>
  </thead>

<hr>