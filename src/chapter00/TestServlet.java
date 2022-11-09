package chapter00;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 複数のチェックボックス
 * Servlet implementation class Greeting
 */
@WebServlet("/chapterXX/radiotst")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String gender = request.getParameter("gender");
		
		if ("M".equals(gender)) {
			// 男性の場合
			request.getRequestDispatcher("/chapterXX/man.jsp").forward(request, response);
		} else {
			// 女性の場合
			request.getRequestDispatcher("/chapterXX/women.jsp").forward(request, response);
		}	
	}
}
