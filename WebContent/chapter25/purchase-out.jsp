<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.html"%>
<%@ include file="menu.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!-- 購入成功時のメッセージ -->
<p>購入手続きが完了しました。</p>
<p>
  <%
  out.println(new java.text.SimpleDateFormat("yyyy年 MM月 dd日 HH時 mm分 ss秒").format(new java.util.Date()));
  %>
</p>

<%@ include file="../footer.html"%>