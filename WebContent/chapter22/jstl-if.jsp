<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- chapter22 JSTL タグライブラリ リストの要素を取り出す -->
<p>
	抽選結果:
	<c:choose>
		<c:when test="${Math.random() < 0.5	}">あたり</c:when>
		<c:when test="${Math.random() > 0.5}">はずれ</c:when>
		<c:otherwise>?</c:otherwise>
	</c:choose>

	
	${Math.random()}
</p>
<%@ include file="../footer.html"%>