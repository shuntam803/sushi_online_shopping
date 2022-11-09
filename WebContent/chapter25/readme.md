## 寿司オンラインショッピング

	


	-- sushi-online-shopping --
		-- WebContent
			-- chapter24
				- login-in.jsp					<--  ログインの入力画面
				- login-out.jsp					<--  ログインの出力画面
				- login-error.jsp					<--  ログインのエラー画面
				- logout-in.jsp					<--  ログアウトの入力画面
				- logout-out.jsp					<--  ログアウトの出力画面
				- logout-error.jsp					<--  ログアウトのエラー画面	
			-- chapter25
				- menu.jsp						<--  メニュー画面
				- index.jsp						<--  ウェルカム画面
				- product.jsp					<--  商品検索画面
				- cart.jsp						<--  カート画面
				- preview-error-login.jsp				<--  購入前のエラー画面(未ログイン)
				- preview-error-cart.jsp				<--  購入前のエラー画面(カートが空)
				- purchase-in.jsp					<--  購入画面
				- purchase-out.jsp					<--  購入結果画面
				- purchase-error-empty.jsp				<--  購入エラー画面(入力の不備)
				- purchase-error-insert.jsp				<--  購入エラー画面(データベースの処理)
				-- image
					- 1.jpg ~ 17.jpg				<--  画像ファイル(1 ~ 17)
		-- src
			-- tool
				- EncodingFilter.java				<--  文字エンコーディングを設定するフィルタ
				- FrontController.java				<--  フロントコントローラ
				- Action.java					<--  アクション
				-- bean
				- Product.java					<--  商品Bean
				- Customer.java					<--  顧客Bean
				- Item.java						<--  項目Bean
			-- dao
				- ProductDAO.java					<--  商品テーブルの操作
				- CustomerDAO.java					<--  顧客テーブルの操作
				- Purchase.java					<--  購入テーブルの操作
			-- chapter24
				- LoginAction.java					<--  ログインのアクション
				- LogoutAction.java					<--  ログアウトのアクション
			-- chapter25
				- ProductAction.java				<--  商品を検索するアクション
				- CartAddAction.java				<--  カートに追加するアクション
				- CartRemoveAction.java				<--  カートから削除するアクション
				- PreviwAction.java					<--  購入手続きを準備するアクション
				- PurchaseAction.java				<--  購入手続きのアクション
						