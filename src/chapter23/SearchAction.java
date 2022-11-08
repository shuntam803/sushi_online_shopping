package chapter23;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

/**
 * 検索の処理をアクション
 * @author c3user
 *
 */
public class SearchAction extends Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = null;
		
		// serch.jspで入力された検索キーワードをリクエストパラメーターから取得
		String keyword = request.getParameter("keyword");
		
		ProductDAO dao = new ProductDAO();
		conn = dao.getConnection();
		List<Product> list = dao.search(conn, "%" + keyword + "%");
		
		request.setAttribute("list", list);
		
		conn.close();
		
		return "list.jsp";
		
	}

}
