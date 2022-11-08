<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- chapter22 JSTL タグライブラリ リストの要素を取り出す -->
<table border="1">
	<tr bgcolor="pink">
		<th>番号</th>
		<th>商品</th>
		<th>価格</th>
	</tr>
	
	<!-- 番号、商品名、価格のリストを取り出す -->
	<c:forEach var="product" items="${list}">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
		</tr>
	</c:forEach>
	
	<!-- 合計の表示 -->
	<tr>
		<th colspan="2" bgcolor="gray">合計</th>
		<td bgcolor="gray">${priceSum}</td>
	
	</tr>
</table>

<%@ include file="../footer.html"%>