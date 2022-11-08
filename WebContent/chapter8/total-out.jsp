<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- pageディレクティブのerrorPageを使ってエラーページの設定をする --%>

<%@ page errorPage="total-error.jsp" %>
<%@include file="../footer.html"%>

<%-- 入力された数字をもとにに計算 --%>

<% request.setCharacterEncoding("UTF-8");
   try {
   	   int price = Integer.parseInt(request.getParameter("price"));
       int count = Integer.parseInt(request.getParameter("count"));
%>

<%= price %>円×<%= count %>個＝<%= price * count %>円
<% } catch (NumberFormatException e) {
	out.println("<p>⚠⚠⚠数値を入力してください⚠⚠⚠</p>");
	out.println(e);
   }
   %>

<%@include file="../footer.html"%>