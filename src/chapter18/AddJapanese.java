package chapter18;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * 日本語を含むクッキーを追加するプログラム
 * @author c3user
 */
@WebServlet("/chapter18/add-japanese")
public class AddJapanese extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// レスポンス追加の際にURLエンコードを行う
		String name = URLEncoder.encode("名前", "UTF-8");
		String value = URLEncoder.encode("値", "UTF-8");
		
		// Cookiekラスのコンストラクタを使ってクッキーを生成
		Cookie cookie = new Cookie(name, value);
		// setMaxAgeでクッキーの生存期間を秒単位で設定[(60秒×60秒×24秒＝１日(86400秒)]
		cookie.setMaxAge(60 * 60 * 24);
		// addCookieメソッドでクッキーを追加
		response.addCookie(cookie);
		
		out.println("クッキーを追加しました。");
		
		Page.footer(out);
		
	}
}
