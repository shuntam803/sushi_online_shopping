package chapter17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/chapter17/cart-add2")
public class CartAdd2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// cart-add2.jspで入力された文字
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String add = request.getParameter("add");
		String clear = request.getParameter("clear");

		// セッション開始
		HttpSession session = request.getSession();
		
		if (add != null) {
			// セッション属性からcartの名を持つ属性を取得し商品Beanのリストであるcartに代入する
			List<Product> cart = (List<Product>) session.getAttribute("cart");
			
			if (cart == null) {
				cart = new ArrayList<Product>();
			}
			// Beanの作成とリストの追加
			Product prod = new Product();
			prod.setName(name);
			prod.setPrice(Integer.parseInt(price));
			cart.add(prod);
			
			session.setAttribute("cart", cart);
		}	
		
		if (clear != null) {
			session.removeAttribute("cart");
			
		}
			request.getRequestDispatcher("cart-add2.jsp").forward(request, response);

	}

}
