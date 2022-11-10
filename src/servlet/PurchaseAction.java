package servlet;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import dao.PurchaseDAO;
import tool.Action;

/**
 * 購入を確定するアクション
 * @author c3user
 */
public class PurchaseAction extends Action {
	

	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = null;
		
		// return先のJSPを指定するための文字列
		String url = "../views/cart.jsp";
		
		// セッション取得
		HttpSession session = request.getSession();
		
		// preview.jspから送られた名前と住所を取得
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		// 名前または住所が空の場合は"purchase-error-empty.jspへフォワード
		if (name.isEmpty() || address.isEmpty()) {
			return "../views/purchase-error-empty.jsp";
		}
		
		
		PurchaseDAO dao = new PurchaseDAO();
		conn = dao.getConnection();
		conn.setAutoCommit(false);
		
		// セッション属性からカート情報を取得
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		// カートの取得、データベースの処理に失敗した場合は"
		if (cart == null || !dao.insert(cart, name, address)) {
			// カートに関するメッセージの画面へ移行
			conn.rollback();
			return "../views/purchase-error-insert.jsp";
		}
		
		// 問題なければセッションを削除して購入成功画面へ移行
		conn.commit();
		conn.setAutoCommit(true);
		session.removeAttribute("cart");
		url = "../views/purchase-out.jsp";
		return url;
	}
}