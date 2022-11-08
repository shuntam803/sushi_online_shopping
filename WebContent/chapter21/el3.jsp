<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<!-- chapter21 三項演算子を使ったサンプル"a ? b : c" -->
<!-- 
	 Math.random < 0.5 ? "あたり" : "はずれ"
	 乱数を生成して0.5以上ならあたり、0.5未満ならはずれ
 -->
<p>${Math.random() < 0.5 ? "あたり" : "はずれ"}</p> 

<%@include file="../footer.html"%>