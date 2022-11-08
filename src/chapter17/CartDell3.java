package chapter17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * カートの削除
 * @author c3user
 *
 */
@WebServlet(urlPatterns = { "/chapter17/cart-dell3" })
public class CartDell3 extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		request.getRequestDispatcher("cart-add3.jsp").forward(request, response);
	}

}
