package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

/**
 * 購入前の確認アクション
 * @author c3user
 */
public class PreviewAction extends Action {
	/**
	 * 
	 * @return それぞれのjspへ返す
	 */
	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// return先のJSPを指定するための文字列
		String url;
		
		// セッション取得
		HttpSession session = request.getSession();
		
		// セッション属性から顧客情報を取得
		if (session.getAttribute("customer") == null) {
			// nullの場合は未ログインなのでエラー画面へ移行
			url = "preview-error-login.jsp";
		}
		
		// セッション属性からカート情報を取得
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		if (cart == null || cart.size() == 0) {
			// // カートのリストがnull、かつカートの空の場合カートに関するメッセージの画面へ移行
			url = "preview-error-cart.jsp";
		} else {
			// ログイン済みでカートが空ではない場合、購入画面へ移行
			url = "purchase-in.jsp";
		}
		
		// ログイン済みでカートが空ではない場合、購入画面へ移行
		return url;
	}
}