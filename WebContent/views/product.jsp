<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<%@ include file="menu.jsp"%>

<!-- 商品検索画面 -->
<div class="container-fluid">
	<!-- <p>検索キーワードを入力してください。</p>

	<form action="Product.action" method="post">
		<input type="text" name="keyword"> <input type="submit"
			value="検索">
	</form> -->


	<table class="table table-bordered""text-center">
		<c:forEach var="product" items="${list}">
			<tr>
				<td>商品${product.id}</td>
				<td><img src="../images/product/${product.id}.jpg" height="64"></td>
				<td style="text-align: center">${product.name}</td>
				<td style="text-align: right">${product.price}円</td>
				<td><a href="CartAdd.action?id=${product.id}">カートに追加</a></td>
			</tr>

		</c:forEach>
	</table>
</div>
<%@ include file="../footer.jsp"%>