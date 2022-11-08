package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

/**
 * DAOを使った商品追加サーブレット
 * @author c3user
 */
@WebServlet("/chapter15/insertdao")
public class InsertDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		Connection conn = null;
		ProductDAO dao = new ProductDAO();


		try {
			// insert.jspで入力したnameとprice
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			Product prod = new Product();
			prod.setName(name);
			prod.setPrice(price);
			
			// 接続
			conn = dao.getConnection();
			
			// オートコミット
			conn.setAutoCommit(false);

			// データベース実行(prodを引数にしてinsertメソッドを実行)
			int line = dao.insert(conn, prod);

			if (line > 0) {
				out.println("追加に成功しました。");
			}

			// 例外処理(ブラウザに表示)
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);

	}

}