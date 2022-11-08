<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="java.util.Map, java.util.HashMap" %>

<%-- ELの暗黙オブジェクト --%> 

<p>リクエストパラメーターの値 </p>
${param.user}
<p>リクエストパラメーターの値の文字数 </p>
${param.user.length()}
<p>リクエストパラメーターの値を大文字に変換して出力 </p>
${param.user.toUpperCase()}


<%@include file="../footer.html"%>