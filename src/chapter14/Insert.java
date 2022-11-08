package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

/**
 * productテーブルから商品を登録するサーブレット
 * @author c3user
 */
@WebServlet("/chapter14/insert")
public class Insert extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			// コンストラクタを使って"InitialContext"オブジェクトを取得
			InitialContext ic = new InitialContext();
			
			// データベースへ接続するための"DataSource"オブジェクトを取得
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection conn = ds.getConnection();
			
			// insert.jspで入力された文字
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			// SQL文を送信
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PRODUCT VALUES (null, ?, ?)");
			
			// リクエストパラメーターから取得した値でプレースホルダを置き換える
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			
			// executeUpdateメソッドを実行して処理した行数を取得する
			int line = pstmt.executeUpdate();
			
			// lineが0以上の時実行する
			if (line > 0) {
				out.println("追加に成功しました。");
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