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
 * クッキーを使ったカウンター
 * ブラウザを更新するたびにカウントアップする
 * @author c3user
 */
@WebServlet("/chapter18/count")
public class Count extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// Cookie[] getCookies()メソッドを使ってクッキーを取得する
		Cookie[] cookies = request.getCookies();
		
		// ①カウンタ
		Integer count = null;
		
		// ②クッキーが保存されている場合
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// ⑥繰り返し処理の中でクッキーの名前がcountと同じかチェック
				if (cookie.getName().equals("count")) {
					// ⑦名前がcountであった場合は値を取得して整数(Integer)に変換する
					count = Integer.valueOf(cookie.getValue());
					break;
				}
			}
		}
		
		// ③クッキーに何も保存されてない場合
		if (count == null) {
			count = 0;
		} 
		// ④countの値を1増やす
		count++;
		
		// ⑤カウンタの値をcountという名前のクッキーに保存
		Cookie cookie = new Cookie("count", count.toString());
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
		
		// countが10になったらクッキーを削除
		if (count == 10) {
			out.println("クッキーを削除しました。");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		out.println(count);
			
		Page.footer(out);

	}

}
