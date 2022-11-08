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
 * productテーブルから商品を追加するサーブレット
 * 登録済みの場合はメッセージ出力
 * @author c3user
 */
@WebServlet("/chapter14/transaction")
public class Transaction extends HttpServlet {


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
			
			// ①オートコミットしない
			conn.setAutoCommit(false);
			
			// ②追加する商品名と価格でSQL文を送信
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PRODUCT VALUES (NULL, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.executeUpdate();
			
			// ③で追加した商品名を持つ行を商品テーブルから検索して結果(ResultSet)を取得
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE NAME = ?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			// ④ 結果の行数が一致した場合追加をする
			int line =0;
			while (rs.next()) {
				line++;
			}			
			// ⑤lineが1の場合実行する
			if (line == 1) {
				conn.commit();
				out.println("商品を登録しました。");
			} else {
				// ⑥lineが1以外の場合この場合は複数の行が検索されたと
				//   判断できるのでrollbackメソッドを使ってデータベースへの変更を取り消す
				conn.rollback();
				out.println("商品はすでに登録されています。");
			}
			// ⑦自動コミット有効に変更
			conn.setAutoCommit(true);
			
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