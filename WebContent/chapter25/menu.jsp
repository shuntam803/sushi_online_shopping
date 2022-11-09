<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>



<p>
	<%
	out.println(new java.text.SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒").format(new java.util.Date()));
	%>
</p>

<!-- メニュー画面 -->

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="../chapter25/index.jsp"><img src="image/17.jpg" height="24" /><svg
				xmlns="http://www.w3.org/2000/svg" width="16" height="16"
				fill="currentColor" class="bi bi-emoji-laughing" viewBox="0 0 16 16">
  <path
					d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
  <path
					d="M12.331 9.5a1 1 0 0 1 0 1A4.998 4.998 0 0 1 8 13a4.998 4.998 0 0 1-4.33-2.5A1 1 0 0 1 4.535 9h6.93a1 1 0 0 1 .866.5zM7 6.5c0 .828-.448 0-1 0s-1 .828-1 0S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 0-1 0s-1 .828-1 0S9.448 5 10 5s1 .672 1 1.5z" />
</svg>鮨処 博多</a>
		<div class="text-right">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="../chapter25/Product.action">商品</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../chapter25/cart.jsp">カート</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../chapter25/Preview.action">購入</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../chapter24/login-in.jsp">ログイン</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../chapter24/logout-in.jsp">ログアウト</a></li>
				</ul>
				<form class="d-flex" action="Product.action" method="post">
					<input class="form-control me-2" type="text" name="keyword"
						placeholder="検索キーワード" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">検索</button>
				</form>

			</div>
		</div>
	</div>
</nav>

