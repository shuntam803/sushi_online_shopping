<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>


<!-- chapter22 JSTL スクリプトレットと式をJSTLとELにかえる -->

<% for(int i = 1; i < 10; i++) { %>
	<%= i %>×<%= i %> = <%= i * i %><br>
<% } %>

<%@ include file="../footer.html"%>