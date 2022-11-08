package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;

public class CustomerDAO extends DAO {
	
	/** ログイン名とパスワード検索のSQL文 */
	private static final String SELECT_CUSTOMER = "SELECT * FROM CUSTOMER "
			+ "WHERE LOGIN = ? AND PASSWORD = ?";
	
	/**
	 * ログイン機能。
	 *customerテーブルから顧客を検索するためのsearchメソッドのみを定義
	 *searchメソッドは指定したログイン名とパスワードの顧客をcustomerテーブルから検索し
	 *見つかった場合には顧客Beanを返す。見つからなかった場合はnullを返す
	 * @param  conn      コネクション
	 * @param  login     ログイン名
	 * @param  password  パスワード
	 * @return customer  顧客情報
	 * @throws Exception 例外
	 */
	public Customer search(Connection conn, String login, String password)throws Exception {
		
		Customer customer = null;
		
		// SQL文のステートメント取得
		PreparedStatement pstmt = conn.prepareStatement(SELECT_CUSTOMER);
		
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		// 検索結果であるrsオブジェクトから1行ずつ取り出し、各列の値を新たに生成 
		while (rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}
		// クローズ処理
		pstmt.close();
		
		return customer;
	}
}