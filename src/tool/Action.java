package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * アクションのスーパークラス
 * Servlet implementation class Action
 */

public abstract class Action {
	/**
	 * @param execute    メソッドをオーバーライドし、各機能の処理を記述する
	 * @param request    リクエストパラメータの取得やリクエスト属性の設定に使う
	 * @param response   レスポンスはJSPファイルで出力するので本書では使用しない
	 * @return
	 * @throws Exception 例外
	 */
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	
}
