package tool;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySQLConnection {
	
	public static Connection getConnection() throws Exception {
	// コンストラクタを使って"InitialContext"オブジェクトを取得
	InitialContext ic = new InitialContext();
	// データベースへ接続するための"DataSource"オブジェクトを取得
	DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
		
	return ds.getConnection();
	}

}
