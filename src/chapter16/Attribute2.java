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

/**
 * データベース処理とリクエスト属性を使ったサーブレット
 * サーブレットがデータベースから取得したデータをJSPに
 * 渡してJSPで表示するプログラム
 * @author c3user
 */
@WebServlet("/chapter16/attribute2")
public class Attribute2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {
			// ProductDAOから全商品の商品を取得する
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search("keyword");

			// setAttributeメソッドを使いリクエスト属性に商品のリストを設定する属性はlist
			request.setAttribute("list", "%" + list + "%");

			// "attribute2.jsp"にフォワードする
			request.getRequestDispatcher("/chapter16/attribute2.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}