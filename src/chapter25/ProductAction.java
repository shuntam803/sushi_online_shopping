package chapter25;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

/**
 * 商品を検索するアクション
 * @author c3user
 */
public class ProductAction extends Action {
	/**
	 * 
	 * @return product.jspへ返す
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// セッション取得
		HttpSession session = request.getSession();
		
		// 検索キーワードの取得
		String keyword = request.getParameter("keyword");
		
		// nullの場合すべての商品を検索
		if (keyword == null) {
			keyword = "";
		}
		
		// 検索の実行
		ProductDAO dao = new ProductDAO();
		Connection conn = dao.getConnection();
		
		List<Product> list = dao.search(conn, "%" + keyword + "%");
		
		// 商品リストをセッション属性に設定
		session.setAttribute("list", list);
		
		conn.close();;
		
		return "product.jsp";
	}
	
}
