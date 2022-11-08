package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Page;

/**
 * セッション属性の活用例
 * カート内の商品を表示する
 * @author c3user
 */
@WebServlet("/chapter17/cart-get")
public class CartGet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		// セッション開始
		HttpSession session = request.getSession();

		// セッション属性からcartの名を持つ属性を取得し商品Beanのリストであるcartに代入する
		List<Product> cart = (List<Product>) session.getAttribute("cart");

		// nullではない場合
		if (cart != null) {
			// 拡張for文で取得したリストからすべての商品取り出す(商品名：価格)
			for (Product prod : cart) {
				out.println("<p>");
				out.println(prod.getName());
				out.println(":");
				out.println(prod.getPrice());
				out.println("</p>");
			}
		} else {
			out.println("カートに商品は入っていません。");
		}

		Page.footer(out);

	}

}
