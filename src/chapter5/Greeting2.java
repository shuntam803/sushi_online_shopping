package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * POSTリクエストを処理するサーブレット
 * Servlet implementation class Greeting
 */
@WebServlet("/chapter5/greeting2")
public class Greeting2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 文字エンコーディングをUTF-8に指定
		request.setCharacterEncoding("UTF-8");
		// greeting2.htmlで指定したname属性値の"user"
		String user = request.getParameter("user");
		
		Page.header(out);
		// メッセージの出力
		out.println("<p>こんにちは、" + user + "さん</p>");
		Page.footer(out);
		
	}

}
