package chapter18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * クッキーを取得するプログラム
 * @author c3user
 */
@WebServlet("/chapter18/get")
public class Get extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		// Cookie[] getCookies()メソッドを使ってクッキーを取得する
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			// 拡張for文を使ってすべてのクッキーの名前と値を取得して出力
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				out.println("<p>" + name + " : " + value + "</p>");

			}
			// クッキーが存在しない場合
		} else {
			out.println("クッキーは存在しません。");
		}

		Page.header(out);

	}
}
