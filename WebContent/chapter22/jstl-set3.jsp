<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- chapter22 JSTL その他のc:タグ -->

<!-- 変数を削除するタグ -->
<c:set var="message" value="Hello" />
<p>message : ${message}</p>
<c:remove var="message" />
<p>message : ${message}</p>

<!-- 指定した区切り文字で文字列を分割し、部分文字列を取得するタグ -->
<c:forTokens items="黒, 青, 赤, 緑, 黄, 白" delims="," var="color">
<p>${color}</p>
</c:forTokens>



<%@ include file="../footer.html"%>