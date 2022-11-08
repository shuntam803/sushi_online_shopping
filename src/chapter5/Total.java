package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * 計算を行うサーブレット
 * Servlet implementation class Greeting
 */
@WebServlet("/chapter5/total")
public class Total extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			// 文字エンコーディングをUTF-8に指定
			request.setCharacterEncoding("UTF-8");
			/* getParameterメソッドで値を取り出し、
			 * それをIntegerのクラスメソッドであるparseIntに渡して
			 * int型に変換してから変数に代入する */
			int price = Integer.parseInt(request.getParameter("price"));
			int count = Integer.parseInt(request.getParameter("count"));
				
			Page.header(out);
			// メッセージの出力
			out.println(price + "円×");
			out.println(count + "個＝");
			out.println(price * count + "円");
			Page.footer(out);
			
			// 例外処理
		} catch(NumberFormatException e) {
			out.println("数値を入力してください");
		}
	}
}
