package chapter19;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * アプリケーション属性を取得するサンプル
 * @author c3user
 */
@WebServlet("/chapter19/attribute3")
public class Attribute3 extends HttpServlet {

	/**
	 * @throws 例外処理
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		// getAServletContextメソッドによりServletContextオブジェクトを取得
		ServletContext context = getServletContext();
		
		// 属性名debugを取得してString型に代入
		String debug = (String)context.getAttribute("debug");
		
		// 値が"yes"と同じ場合
		if (debug.equals("yes")) {
			out.println("<p>デバッグモードで実行します。</p>");
		}
		
		// 属性名"memory"を取得しint型に代入
		int memory = Integer.parseInt((String)context.getAttribute("memory"));
		
		// memoryが1000000よりも小さい場合
		if (memory > 1000000) {
			out.println("<p>省メモリーモードで実行します。</p>");
		}
				
		Page.footer(out);

	}

}