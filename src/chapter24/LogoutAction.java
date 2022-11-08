package chapter24;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

/**
 * ・ログアウトアクションの作成
 * (1)セッション取得
 * (2)セッション属性として設定された顧客Beanを取得
 * (3)ログインしている場合は顧客Beanを取得できる。セッション属性から
 *    顧客Beanを削除した後にログアウト成功ページにフォワード
 * (4)ログインしていない場合は顧客Beanを取得できない。ログアウト失敗ページにフォワード
 * @author c3user
 *
 */
public class LogoutAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// return先のJSPを指定するための文字列
		String url;
		
		HttpSession session = request.getSession();
		
		// ログインしている場合
		if (session.getAttribute("customer") != null) {
			session.removeAttribute("customer");
			// logout-out.jspへフォワード
			url = "logout-out.jsp";
		} else {
			url = "logout-error.jsp";
		}
		// 顧客が取得できなかったらログアウト失敗、もじくはすでにログアウト済み。
		return url;
	}
}
