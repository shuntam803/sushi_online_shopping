package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.Product;
import tool.Action;

/**
 * @author shuntam
 */
@SuppressWarnings("unchecked")
public class CartAddAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// ① セッション取得
		HttpSession session = request.getSession();
		
		// return先のJSPを指定するための文字列
		String url = "../views/cart.jsp";

		// ② 商品番号の取得
		int id = Integer.parseInt(request.getParameter("id"));

		// ③ セッション属性からカート(Item)を取得
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if (cart == null) {
			// // ④ カート内が空の場合リストを生成しセッション属性に設定
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}
		
		// ⑤ 拡張for文で追加する商品とカート内の配列を取得
		boolean blCart = false;
		for (Item item : cart) {
			// 追加する商品に商品番号(id)がある場合、個数(count)を1件追加する
			if (item.getProduct().getId() == id) {
				item.setCount(item.getCount() + 1);
				blCart = true;
				break;
			}
		}

		if (!blCart) {
			// ⑥ セッション属性から商品情報(Product)を取得
			List<Product> list = (List<Product>) session.getAttribute("list");
			for (Product prod : list) {
				// ⑦ すでに商品番号がカートに存在している場合個数を1増やす
				if (prod.getId() == id) {
					Item item = new Item();
					item.setProduct(prod);
					item.setCount(1);
					cart.add(item);
					break;
				}
			}
		}
		return url;
	}
}