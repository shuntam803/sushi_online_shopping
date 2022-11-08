<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<!-- JSPでrequest2.javaと同じ表示をする -->

<p>
    Method<br><%=request.getMethod() %>
  </p>

<% 
// ①HTTPのメソッドを表示
out.println("<p>Method<br>" + request.getMethod() + "</p>");
// ②リクエストされたURIを表示
out.println("<p>Request URI<br>" + request.getRequestURI() + "</p>");
// ③コンテキストパスを表示
out.println("<p>Context Path<br>" + request.getContextPath() + "</p>");
// ④サーブレットのパスを表示
out.println("<p>Servlet Path<br>" + request.getServletPath() + "</p>");
// ⑤リクエストパラメーターを表示
out.println("<p>Query String<br>" + request.getQueryString() + "</p>");
// ⑥プロトコル(HTTPのバージョン)を表示
out.println("<p>Protocol<br>" + request.getProtocol() + "</p>");
// ⑦リクエストされたURLを表示
out.println("<p>Request URL<br>" + request.getRequestURL() + "</p>");
// ⑧スキームを表示
out.println("<p>Scheme<br>" + request.getScheme() + "</p>");
// ⑨ホスト名を表示
out.println("<p>Server Name<br>" + request.getServerName() + "</p>");
// ⑩ポート番号を表示
out.println("<p>Server Port<br>" + request.getServerPort() + "</p>");

%>

<%@include file="../footer.html" %>