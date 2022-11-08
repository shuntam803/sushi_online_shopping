<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<!-- キーワードを入力して追加するためのJSPファイル -->
	<p>追加する商品を入力してください</p>
	<form action ="insertdao" method="post">
	
	<p>商品名</p>
		<input type="text" name="name">
	<p>価格</p>	
		<input type="text" name="price">
		
	<p><input type="submit" value="追加"></p>
	</form>

<%@include file="../footer.html" %>