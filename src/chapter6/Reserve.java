package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * 複数のチェックボックス
 * Servlet implementation class Greeting
 */
@WebServlet("/chapter6/reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 文字エンコーディングをUTF-8に指定
		request.setCharacterEncoding("UTF-8");

		// 人数(count)と座席の種類(seat)
		String count = request.getParameter("count");
		String seat = request.getParameter("seat");

		Page.header(out);
		// メッセージの出力
		out.println("<p>" + count + "名様で" + seat + "のご予約を承りました。");
		// reserve.htmlからoption属性を取得
		String[] values = request.getParameterValues("option");
		// ケーキや花束の有無を確認
		if (values != null) {
			for (String value : values) {
				out.println("「" + value + "」をご用意いたします。");
			}
			out.println("</p>");
		}
		
		Page.footer(out);
	}
}
