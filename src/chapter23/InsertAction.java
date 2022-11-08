package chapter23;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

/**
 * 追加の処理をアクション
 * @author c3user
 *
 */
public class InsertAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = null;

		try {

			// insert.jspで入力された商品名と価格をリクエストパラメーターから取得
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));

			// 追加
			Product prod = new Product();
			prod.setName(name);
			prod.setPrice(price);

			// 実行
			ProductDAO dao = new ProductDAO();
			conn = dao.getConnection();
			conn.setAutoCommit(false);
			dao.insert(conn, prod);
			conn.commit();

			// リクエスト属性の設定
			List<Product> list = dao.search(conn, "%");
			
			request.setAttribute("list", list);

			conn.close();

		} catch (SQLException e) {
			conn.rollback();
		}

		return "list.jsp";

	}

}
