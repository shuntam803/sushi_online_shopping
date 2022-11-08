package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import bean.Item;
import bean.Product;

/**
 * 購入情報の登録をするPurchaseDAOクラス
 * @author c3user
 *
 */
public class PurchaseDAO extends DAO {

	/** 購入情報追加のSQL文 */
	private static final String INSERT_PURCHASE = "INSERT INTO "
			+ "PURCHASE(PRODUCT_ID, "
			+ "PRODUCT_NAME, "
			+ "PRODUCT_PRICE, "
			+ "PRODUCT_COUNT, "
			+ "CUSTOMER_NAME, "
			+ "CUSTOMER_ADDRESS) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";

	/**
	 * 追加を行うinsertメソッド
	 * @param cart        カート情報
	 * @param name        氏名
	 * @param address     住所
	 * @return boolean    処理実行が成功した場合true、失敗した場合falseで返す
	 * @throws Exception  例外のスロー
	 */
	public boolean insert(List<Item> cart, String name, String address) throws Exception {

		Connection conn = getConnection();
		conn.setAutoCommit(false);

		// 拡張for文で現在カートに入っている種類の数だけinsert文を実行して、purchaseテーブルに行を追加する
		for (Item item : cart) {

			PreparedStatement pstmt = conn.prepareStatement(INSERT_PURCHASE);

			Product prod = item.getProduct();

			pstmt.setInt(1, prod.getId());
			pstmt.setString(2, prod.getName());
			pstmt.setInt(3, prod.getPrice());
			pstmt.setInt(4, item.getCount());
			pstmt.setString(5, name);
			pstmt.setString(6, address);

			// 正常に更新すると1、失敗すると0で変更した行数を返す
			int line = pstmt.executeUpdate();

			pstmt.close();

			// insert文のいずれかが失敗した場合の処理
			if (line != 1) {
				conn.rollback();
				
				return false;
			}
		}
		// SQL文が成功した場合の処理
		conn.commit();

		return true;

	}

}
