package chapter19;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

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
@WebServlet("/chapter19/attribute2")
public class Attribute2 extends HttpServlet {

	/**
	 * @throws 例外処理
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		// getAServletContextメソッドによりServletContextオブジェクトを取得
		ServletContext context = getServletContext();

		// getAttributeNamesメソッドでアプリケーション属性名の一覧を取得しString型のリストに代入
		List<String> list = Collections.list(context.getAttributeNames());
		
		// listの配列を取得
		for (String name : list) {
			// getgetAttributeメソッドで取得して出力
			out.println("<p>" + name + " : " + context.getAttribute(name) + "</p>");
			
		}
		
		Page.footer(out);

	}

}