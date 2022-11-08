package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
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
 * 検索の処理をアクション
 * @author c3user
 *
 */
@WebServlet(urlPatterns = { "/chapter17/cart-add3" })
public class CartAdd3 extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));

			HttpSession session = request.getSession();
			
			// カートの中身
			@SuppressWarnings("unchecked")
			List<Product> cart = (List<Product>) session.getAttribute("cart");
			if (cart == null) {
				cart = new ArrayList<Product>();

			}
			Product prod = new Product();
			prod.setName(name);
			prod.setPrice(price);
			cart.add(prod);
			session.setAttribute("cart", cart);

			
			int total = 0;
			int cnt = 0;
			for (Product pro : cart) {
				total += pro.getPrice();
				cnt++;
			}

			request.setAttribute("cart", cart);
			request.setAttribute("total", total);
			request.setAttribute("cnt", cnt);

			request.getRequestDispatcher("cart-add3.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}
}