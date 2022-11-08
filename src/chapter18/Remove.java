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
 * クッキーを削除するプログラム
 * サーブレットのAPIには削除するためのメソッドは用意されていません。
 * setMaxAgeメソッドにより生存期間を0に設定してクッキーを追加する。
 * @author c3user
 */
@WebServlet("/chapter18/remove")
public class Remove extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		// Cookie[] getCookies()メソッドを使ってクッキーを取得する
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			// 拡張for文を使ってすべてのクッキーの名前と値を取得して出力
			for (Cookie cookie : cookies) {
				// setMaxAgeメソッドで生存期間を0に設定する
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		out.println("クッキーを削除しました。");
		Page.header(out);
	}
}
