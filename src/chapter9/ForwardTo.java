package chapter9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * サーブレットからサーブレットにフォワードするプログラム
 * フォワード先 
 */

@WebServlet("/chapter9/forward-to")
public class ForwardTo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワードを行うプログラム
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Page.header(out);
		out.println("<h1>フォワード先のサーブレットです。</h1>");
		Page.footer(out);
	}

}
