<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<% request.setCharacterEncoding("UTF-8"); %>

  <p>
    Method<br><%=request.getMethod() %>
  </p>
  <p>
    Request URL<br><%=request.getRequestURI() %>
  </p>
  <p>
    Context Path<br><%=request.getContextPath() %>
  </p>
  <p>
    Servlet Path<br><%=request.getServletPath() %>
  </p>
  <p>
    Query String<br><%=request.getQueryString() %>
  </p>
  <p>
    Protocol<br><%=request.getProtocol() %>
  </p>
  <p>
    Request URL<br><%=request.getRequestURL() %>
  </p>
  <p>
    Scheme<br><%=request.getScheme() %>
  </p>
  <p>
    Server Name<br><%=request.getServerName() %>
  </p>
  <p>
    Server Port<br><%=request.getServerPort() %>
  </p>

<%@ include file="../footer.html" %>