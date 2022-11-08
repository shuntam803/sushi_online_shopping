package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
/**
 * 商品の検索と追加を行うProductDAOクラス
 * @author c3user
 *
 */
public class ProductDAO extends DAO {
	
	/** 商品検索のSQL文 */
	private static final String SELECT_PRODUCT = "SELECT * FROM PRODUCT "
			+ "WHERE NAME LIKE ?";
	
	/** 商品追加のSQL文 */
	private static final String INSERT_PRODUCT = "INSERT INTO PRODUCT "
			+ "VALUES(NULL, ?, ?)";
	
	/**
	 * 検索を行うsearchメソッド
	 * @param       conn データベースのコネクション
	 * @param    keyword servletからリクエストを受け取るためのキーワード
	 * @return      list 検索結果の商品のリスト
	 * @throws Exception 例外
	 */
	public List<Product> search(Connection conn, String keyword) throws Exception {
		
		// リストを宣言 
		List<Product> list = new ArrayList<>();
		
		// SQL文のステートメント取得
		PreparedStatement pstmt = conn.prepareStatement(SELECT_PRODUCT);
		pstmt.setString(1, keyword);
		
		// 結果を送信
		ResultSet rs = pstmt.executeQuery();
		
		// 検索結果であるrsオブジェクトから1行ずつ取り出し、各列の値を新たに生成 
		while (rs.next()) {
			Product prod = new Product();
			prod.setId(rs.getInt("id"));
			prod.setName(rs.getString("name"));
			prod.setPrice(rs.getInt("price"));
			list.add(prod);
		}
		// クローズ処理
		pstmt.close();
		
		return list;
	}
	/**
	 * 追加を行うinsertメソッド
	 * @param       conn データベースのコネクション
	 * @param       prod 商品のクラス
	 * @return      line 結果を送信するためのint型の引数
	 * @throws Exception 例外
	 */
	public int insert(Connection conn, Product prod) throws Exception {
		
	
		PreparedStatement pstmt = conn.prepareStatement(INSERT_PRODUCT);
		pstmt.setString(1, prod.getName());
		pstmt.setInt(2, prod.getPrice());
		
		// executeUpdateメソッドの変更した行数を返す
		int line = pstmt.executeUpdate();
		
		// クローズ処理
		pstmt.close();
		
		return line;
	}
	
	/** 教科書のserchメソッド */
	public List<Product> search(String keyword) throws Exception {
		List<Product> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from product where name like ?");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}
	
	/** 教科書のinsertメソッド */
	public int insert(Product product) throws Exception {
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		PreparedStatement st = con.prepareStatement(
				"insert into product values(null, ?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		
		int line = st.executeUpdate();
		if (line > 0) {
			con.commit();
		}
		
		st.close();
		con.close();

		return line;
	}
	
	
}
