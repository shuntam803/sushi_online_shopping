<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- chapter22 JSTL c:setタグを使ったサンプル -->

<!-- 変数messageに対して値Helloを設定し出力 
     JavaだとpageContext.setAttribute("message", "Hello"); -->
<c:set var="message" value="Hello" />
<p>message : ${message}</p>

<!-- 変数message2に対して値Welcomeを設定し出力 -->
<c:set var="message2">Welcome</c:set>
<p>message : ${message2}</p>

<!-- 変数resultに対して1+2の計算結果を設定し出力 -->
<c:set var="result" value="${1+2}" />
<p>result : ${result}</p>

<!-- オブジェクトの使用 -->
<jsp:useBean id="product" class="bean.Product" />
<c:set target="${product}" property="name" value="さんま" />
<p>product.name : ${product.name}</p>

<c:set target="${product}" property="price" value="150" />
<p>product.price : ${product.price}</p>


<%@ include file="../footer.html"%>