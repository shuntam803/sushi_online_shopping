package chapter06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

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
@WebServlet("/chapter06/control")
public class Control extends HttpServlet {
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

		Page.header(out);

		/* getParametersNamesメソッドを使ってリクエストパラメーター名の一覧を取得し
		 * それをlistメソッドに渡してArrayListに変換する */
		List<String> names = Collections.list(request.getParameterNames());
		
		/* 拡張for文で取得したArrayListからリクエストパラメーター名を
		 * 一つ一つ取り出しそれをgetParameterValuesメソッドに渡して値を取得する
		 */
		for (String name : names) {
			String[] values = request.getParameterValues(name);
			for (String value : values) {
				out.println("<p>" + name + " = " + value + "</p>");
			}
		}
		Page.footer(out);
	}
}
