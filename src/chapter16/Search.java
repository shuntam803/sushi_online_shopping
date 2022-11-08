package chapter16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

/**
 * 検索した商品の一覧をフォワード先のJSPファイルで表示するプログラム
 * 入力フォーム(search.jsp)
 * 検索(Search.java)
 * 検索結果(attribute2.jsp)
 * @author c3user
 */
@WebServlet("/chapter16/search16")

public class Search extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		try {
			// serch.jspで入力された文字
			String keyword = request.getParameter("keyword");

			// フォームに入力されたキーワードでデータベースの検索し結果を受け取る
			ProductDAO dao = new ProductDAO();

			// searchメソッドはProductオブジェクトのリストを返すのでそれを変数に代入 
			List<Product> list = dao.search(keyword);

			// setAttributeメソッドを使いリクエスト属性に商品のリストを設定する属性はlist
			request.setAttribute("list", list);
			
			// "attribute2.jsp"にフォワードする
			request.getRequestDispatcher("/chapter16/attribute2.jsp").forward(request, response);


			// 例外処理(ブラウザに表示)
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);

	}

}