package chapter15;
//package chapter15;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import bean.Product;
//import dao.ProductDAO;
//import tool.Page;
//
///**
// * DAOを使った商品検索サーブレット
// * @author c3user
// */
//@WebServlet("/chapter15/search")
//public class Search extends HttpServlet {
//
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		PrintWriter out = response.getWriter();
//		Page.header(out);
//		
//		try {
//			// serch.jspで入力された文字
//			String keyword = request.getParameter("keyword");
//			
//			// フォームに入力されたキーワードでデータベースの検索し結果を受け取る
//			ProductDAO dao = new ProductDAO();
//			
//			// searchメソッドはProductオブジェクトのリストを返すのでそれを変数に代入 
//			List<Product>list = dao.search(keyword);
//			
//			// 拡張for文でリストから商品情報を取得する	
//			for(Product prod : list) {
//				// HTTPのメソッドを表示
//				out.println(prod.getId());
//				out.println("：");
//				out.println(prod.getName());
//				out.println("：");
//				out.println(prod.getPrice());
//				out.println("<br>");
//			}
//			// 例外処理(ブラウザに表示)
//		} catch (Exception e) {
//			e.printStackTrace(out);
//		}
//
//		Page.footer(out);
//
//	}
//
//}