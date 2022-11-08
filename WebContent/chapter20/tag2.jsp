<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<!-- Beanを生成するJSP -->

<!-- useBeanアクションでBeanの属性名はproduct、Beanのクラスはbean.Productクラスで、
	 リクエスト属性からBeanを取得 -->
<jsp:useBean id="product" class="bean.Product" />    

<!-- setPropertyアクションでプロパティの設定 -->
<p>
<jsp:setProperty name="product" property="id" value="2" />
<jsp:setProperty name="product" property="name" value="サーモン" />
<jsp:setProperty name="product" property="price" value="100" />
</p>

<!-- getPropertyアクションを使ったプロパティの取得。id、name、priceを取得 -->
<p>
<jsp:getProperty name="product" property="id" /> : 
<jsp:getProperty name="product" property="name" /> : 
<jsp:getProperty name="product" property="price" />
</p>

<%@ include file="../footer.html" %>