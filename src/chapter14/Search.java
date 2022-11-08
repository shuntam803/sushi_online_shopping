package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.MySQLConnection;
import tool.Page;

/**
 * productテーブルから商品を検索して表示するサーブレット
 * SELECT * FROM PRODUCT
 * WHERE NAME LIKE '軍艦';
 * @author c3user
 */
@WebServlet("/chapter14/search")
public class Search extends HttpServlet {

	private static final String SELECT_PRODUCT = "SELECT * FROM PRODUCT " +
			"WHERE NAME LIKE ?";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			
			Connection conn = MySQLConnection.getConnection();
			// serch.jspで入力された文字
			String keyword = request.getParameter("keyword");
			// SQL文を送信
			PreparedStatement pstmt = conn.prepareStatement(SELECT_PRODUCT);
			// 検索キーワードをワイルドカード(%)で挟む
			pstmt.setString(1, "%" + keyword + "%");
			// 実行＆結果受け取り
			ResultSet rs = pstmt.executeQuery();

			int count = 0;
			while (rs.next()) {
				// HTTPのメソッドを表示
				out.println(rs.getInt("id"));
				out.println("：");
				out.println(rs.getString("name"));
				out.println("：");
				out.println(rs.getInt("price"));
				out.println("<br>");
				count++;
			}
			
			if (count == 0) {
				out.println("対象データ" + keyword + "は登録されていません");
			}
			// クローズ処理
			pstmt.close();
			conn.close();
			
			// 例外処理(ブラウザに表示)
		} catch (Exception e) {
			out.println("対象データがありません");
			e.printStackTrace(out);
		}

		Page.footer(out);

	}

}	