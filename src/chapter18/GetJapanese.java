package chapter18;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * 日本語を含むクッキーを取得するプログラム
 * @author c3user
 */
@WebServlet("/chapter18/get-japanese")
public class GetJapanese extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		
		// Cookie[] getCookies()メソッドを使ってクッキーを取得する
		Cookie[] cookies = request.getCookies();
		
		
		if (cookies != null) {
			// 拡張for文を使ってすべてのクッキーの名前と値を取得して出力
			for (Cookie cookie : cookies) {
				String name = URLDecoder.decode(cookie.getName(), "UTF-8");
				String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
				out.println("<p>" + name + " : " + value + "</p>");
				
			}
		}else {
			out.println("クッキーは存在しません。");
		}
		
		Page.header(out);
		
	}
}
