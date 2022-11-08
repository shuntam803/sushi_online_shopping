package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
 * DAOを使った商品検索サーブレット
 * @author c3user
 */
@WebServlet("/chapter15/searchdao")
public class SearchDAO extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		Connection conn = null;
		ProductDAO dao = new ProductDAO();
		
		try {
			// seach.jspで入力したname
			String name = request.getParameter("name");
			
			// 接続
			conn = dao.getConnection();
			
			// オートコミット
			conn.setAutoCommit(false);
			
			// searchメソッドはProductオブジェクトのリストを返すのでそれを変数に代入 
			List<Product>list = dao.search(conn, "%" + name + "%");
			
			// 拡張for文でリストから商品情報を取得する	
			if (list.size() > 0) {
				for(Product prod : list) {
					// HTTPのメソッドを表示
					out.println(prod.getId());
					out.println("：");
					out.println(prod.getName());
					out.println("：");
					out.println(prod.getPrice());
					out.println("<br>");
				}
				
			}else {
				out.println( name + "は対象データがありません。");
			}
			
			// 例外処理(ブラウザに表示)
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		dao.connClose(conn, out);
		Page.footer(out);
	}

}