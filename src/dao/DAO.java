package dao;
/**
 * データベース接続のためのDAOクラス
 */

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	
	/** コネクション用のデータソース */
	private static final String DATASOURCE = "java:/comp/env/jdbc/sushi_online_shopping";
	
	/** データベースを保存する変数ds */
	private static DataSource ds;
	
	/** コネクションの接続 */
	public Connection getConnection() throws Exception {
		// dsがnullの場合にデータソースを取得する 
		if(ds == null) {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup(DATASOURCE);
		}
		// コネクションの取得
		return ds.getConnection();
	}
	/** コネクションのクローズ */
	public void connClose(Connection conn, PrintWriter out) {
		try {
			conn.close();
		} catch (SQLException e){
			e.printStackTrace(out);
		}
	}
	/** コネクションのロールバック */
	public void connRollback(Connection conn, PrintWriter out) {
		try {
			conn.rollback();
		} catch (SQLException e){
			e.printStackTrace(out);
		}
	}
}
