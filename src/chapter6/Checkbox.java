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
@WebServlet("/chapter6/checkbox")
public class Checkbox extends HttpServlet {
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
		
		// チェックボックス(複数選択のために配列にする)
		String[] genre = request.getParameterValues("genre");
		
		
		Page.header(out);
		
		if (genre != null) {
			// 拡張for文でチェックされた項目の一覧を表示
			for (String item : genre) {
				out.println("「" + item + "」");
				
			}
			// genreにチェックを入れた場合
			out.println("に関する情報をお送りします。");
		} else {
			// genreにチェックを入れなかった場合
			out.println("お買いもの情報はお送りしません。");
		}
		Page.footer(out);

	}
}
