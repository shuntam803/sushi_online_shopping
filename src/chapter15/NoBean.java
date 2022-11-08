package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Beanを使わないで商品情報を表示するプログラム
 * 商品番号、商品名、価格の情報を「１：まぐろ：１００」のように表示する
 * データベースから商品情報を取得するのではなくプログラム内で商品情報を作成する
 */
@WebServlet("/chapter15/nobean")
public class NoBean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// 商品情報の作成
		int id = 1;
		String name = "まぐろ";
		int price = 100;
		
		// 所品情報の表示
		out.println(id);
		out.println(":");
		out.println(name);
		out.println(":");
		out.println(price);
		
		Page.footer(out);
	}

}
