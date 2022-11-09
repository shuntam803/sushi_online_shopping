<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>
<%@ include file="../chapter25/menu.jsp"%>

<!-- ログイン名とパスワードを入力するJSPファイル -->
<div class="text-center">
	<main class="form-signin w-100 m-auto">
		<form action="Login.action" method="post">
			<h1 class="h3 mb-3 fw-normal">サインインをどうぞ</h1>

			<div class="form-floating">
				<input type="text" name="login" class="form-control"
					id="floatingInput" placeholder="nameexample.com"> <label
					for="floatingInput">ログイン名</label>
			</div>
			<div class="form-floating">
				<input type="password" name="password" class="form-control"
					id="floatingPassword" placeholder="パスワード"> <label
					for="floatingPassword">パスワード</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">サインイン</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2022 寿司処 博多</p>
		</form>
	</main>
</div>
<p>
	※テスト用ログイン名 : ayukawa<br>※テスト用パスワード : SweetfishRiver1
</p>
<%@include file="../footer.html"%>