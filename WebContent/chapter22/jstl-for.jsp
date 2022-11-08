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
		<c:forEach var="i" begin="1" end="9">
	<tr>
			<td>${i}</td>
			<td>${i}</td>
			<td>${i}</td>
			
		</c:forEach>
	
	
</table>
<%@ include file="../footer.html"%>