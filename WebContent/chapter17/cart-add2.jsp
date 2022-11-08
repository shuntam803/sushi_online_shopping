<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List, bean.Product, javax.servlet.http.HttpSession"%>
<%@ include file="../header.html"%>



<p>カートに追加する商品を入力してください。</p>

	
	<form action="cart-add2" method="post">
	<div>
		商品名<input type="text" name="name">
		価格<input type="text" name="price">
		<input type="submit" value="追加" name="add">
	</div>
	<div>
		<input type="submit" value="クリア" name="clear">
	</div>
	</form>





<%
HttpSession s = request.getSession();

@SuppressWarnings("unchecked")
List<Product> cart = (List<Product>) s.getAttribute("cart");

if (cart != null) {
	for (Product prod : cart) {
		out.println("<p>");
		out.println(prod.getName());
		out.println(" : ");
		out.println(prod.getPrice());
		out.println("<p>");
	}

}
%>

<%@ include file="../footer.html"%>