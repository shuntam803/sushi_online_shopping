package chapter17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Page;

/**
 * セッション属性の活用例
 * カートを削除する
 * @author c3user
 */
@WebServlet("/chapter17/cart-remove")
public class CartRemove extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// HttpSessionオブジェクトを取得
		HttpSession session = request.getSession();
		
		// セッションを終了
		session.removeAttribute("cart");
		
		// countの値とセッションIDを取得し
		
		out.println("カートを削除しました。");
		request.getRequestDispatcher("cart-add2.jsp").forward(request, response);
		
		Page.footer(out);

	}

}
