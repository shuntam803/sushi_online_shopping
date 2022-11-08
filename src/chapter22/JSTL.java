package chapter22;

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
 * リストの要素を取り出すサンプル
 * サーブレットがデータベースから取得した商品のリストを
 * JSPから取得して出力するプログラム
 * JSTLとELを活用をすることによってJSPファイルが簡潔になっている
 * @author c3user
 *
 */
@WebServlet("/chapter22/jstl")
public class JSTL extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			// ProductDAOから全商品の商品を取得する
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search("");
			
			// 合計
			int priceSum = 0;
			for (Product p : list) {
				priceSum += p.getPrice();
			}
			request.setAttribute("priceSum", priceSum);
			
			// setAttributeメソッドを使いリクエスト属性に商品のリストを設定する属性はlist
			request.setAttribute("list", list);
			
			// "jstl.jsp"にフォワードする
			request.getRequestDispatcher("jstl.jsp").forward(request, response);;
			
		}catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}
