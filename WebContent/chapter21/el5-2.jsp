<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- inclubeディレクティブを使ってheader.htmlを読み込む --%>
<%@include file="../footer.html"%>

<%-- ELの暗黙オブジェクト --%> 

${param["price"]}円×
${param["count"]}個＋送料
${param["delivery"]}円＝
${param.price * param.count + param.delivery}円

<%-- inclubeディレクティブを使ってfooter.htmlを読み込む --%>
<%@include file="../footer.html"%>