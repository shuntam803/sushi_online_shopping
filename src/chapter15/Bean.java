package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import tool.Page;

/**
 * Beanを使って商品情報を表示するプログラム
 * 商品番号、商品名、価格の情報を「１：まぐろ：１００」のように表示する
 * データベースから商品情報を取得するのではなくプログラム内で商品情報を作成する
 */
@WebServlet("/chapter15/bean")
public class Bean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// Productオブジェクトを生成
		Product prod = new Product();
		
		// 値の設定
		prod.setId(1);
		prod.setName("まぐろ");
		prod.setPrice(100);
		
		// 所品情報の表示(値の取得)
		out.println(prod.getId());
		out.println(":");
		out.println(prod.getName());
		out.println(":");
		out.println(prod.getPrice());
		
		Page.footer(out);
	}

}
