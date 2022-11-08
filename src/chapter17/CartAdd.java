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
import tool.Page;

/**
 * セッション属性の活用例
 * カートの商品例
 * @author c3user
 */
@WebServlet("/chapter17/cart-add")
public class CartAdd extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		String name = request.getParameter("name");
		int count = Integer.parseInt(request.getParameter("price"));
		
		// セッション開始
		HttpSession session = request.getSession();
		
		// セッション属性からcartの名を持つ属性を取得し商品Beanのリストであるcartに代入する
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		
		// nullの場合新規にカートのリストを作成する
		if (cart == null) {
			cart = new ArrayList<Product>();
		}
		
		// Beanの作成とリストの追加
		Product prod = new Product();
		prod.setName(name);
		prod.setPrice(count);
		cart.add(prod);
	
		
		// cartにセッション属性にリストを設定する
		session.setAttribute("cart", cart);
		 
		out.println("カートに商品を追加しました。");
		request.getRequestDispatcher("cart-add2.jsp").forward(request, response);
		
		Page.footer(out);

	}

}
