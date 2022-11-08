<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 検索結果を出力するJSPファイル -->


<!-- 検索条件 -->
<c:choose>
  <c:when test="${param.keyword != null}">
    <p>検索キーワード「${param.keyword}」</p>
  </c:when>
  <c:when test="${param.keyword.size() > 0 }">
    <p>「${param.keyword.size()}」件追加しました</p>
  </c:when>
  <c:otherwise>

  </c:otherwise>
</c:choose>



<!-- 戻るボタン実装(<input>要素のhidden型はフォームの送信時にユーザーが見たり変更したりすることができないようにする -->

<form action="search.jsp" method="post">
  <input type="hidden" name="keyword" value="${param.keyword}">
  <input type="submit" value="検索画面に戻る">

  <c:choose>
    <c:when test="${list != null}">
      <input type="submit" value="追加画面に戻る" formaction="insert.jsp">
    </c:when>
    <c:otherwise>
      <input type="submit" value="検索画面に戻る">
    </c:otherwise>
  </c:choose>
</form>

<table border="1">
  <tr bgcolor="pink">
    <th>番号</th>
    <th>商品名</th>
    <th>価格(円)</th>
  </tr>
  <c:choose>
    <c:when test="${list.size() != null}">
      <c:forEach var="prod" items="${list}">
        <tr>
          <td>${prod.id}</td>
          <td>${prod.name}</td>
          <td align="right">${prod.price}</td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <p>検索キーワードに一致するデータはありません。</p>
    </c:otherwise>
  </c:choose>

</table>

<%@ include file="../footer.html"%>