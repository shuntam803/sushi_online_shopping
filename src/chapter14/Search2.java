package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

/**
 * productテーブルから商品を検索して表示するサーブレット
 * SELECT * FROM PRODUCT
 * WHERE NAME LIKE '軍艦';
 * @author c3user
 */
@WebServlet("/chapter14/search2")
public class Search2 extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			// コンストラクタを使って"InitialContext"オブジェクトを取得
			InitialContext ic = new InitialContext();
			// データベースへ接続するための"DataSource"オブジェクトを取得
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection conn = ds.getConnection();
			// serch2.jspで入力された文字
			int price = Integer.parseInt(request.getParameter("price"));
			// SQL文を送信
			PreparedStatement pstmt = conn.prepareStatement("SELECT * "
					+ "FROM PRODUCT "
					+ "WHERE PRICE <= ?");
			// 検索キーワードをワイルドカード(%)で挟む
			pstmt.setInt(1, price);
			// 実行＆結果受け取り
			ResultSet rs = pstmt.executeQuery();

			
			while (rs.next()) {
				// HTTPのメソッドを表示
				out.println(rs.getInt("id"));
				out.println("：");
				out.println(rs.getString("name"));
				out.println("：");
				out.println(rs.getInt("price"));
				out.println("<br>");
			}
			// クローズ処理
			pstmt.close();
			conn.close();
			
			// 例外処理(ブラウザに表示)
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);

	}

}