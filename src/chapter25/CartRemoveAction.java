package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

/**
 * カートに追加するアクション
 * @author c3user
 */
public class CartRemoveAction extends Action {
	/**
	 * 
	 * @return cart.jspへ返す
	 */
	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// セッション取得
		HttpSession session = request.getSession();
		
		// 商品番号の取得
		int id = Integer.parseInt(request.getParameter("id"));
		
		// セッション属性からカート(Item)を取得
		List<Item> cart = (List<Item>)session.getAttribute("cart");
			
		// 拡張for文で追加する商品とカート内の配列を取得
		for (Item item : cart) {
			// カートに商品番号(id)がある場合、削除する
			if (item.getProduct().getId() == id) {
				cart.remove(item);
				break;
			}
		}
		
		return "cart.jsp";
	}
}