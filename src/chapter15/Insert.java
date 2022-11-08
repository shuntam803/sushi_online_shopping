package chapter15;
//package chapter15;
//
//import java.io.IOException;
//import java.io.PrintWriter;
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
// * DAOを使った商品追加サーブレット
// * @author c3user
// */
//@WebServlet("/chapter15/insert")
//public class Insert extends HttpServlet {
//
//	
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		PrintWriter out = response.getWriter();
//		Page.header(out);
//
//		try {
//			// insert.jspで入力された文字
//			String name = request.getParameter("name");
//			int price = Integer.parseInt(request.getParameter("price"));
//
//			// リクエストパラメーターから取得した商品名と価格をsetterで書き込む
//			Product prod = new Product();
//			prod.setName(name);
//			prod.setPrice(price);
//
//			// データベース実行(prodを引数にしてinsertメソッドを実行)
//			ProductDAO dao = new ProductDAO();
//			int line = dao.insert(conn, prod);
//
//			if (line > 0) {
//				out.println("追加に成功しました。");
//			}
//
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