package chapter00;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Crypto {
	
	/**
	 * 指定バイトを暗号化
	 * @param  encryptTarget 暗号化対象バイト
	 * @param  initialVector 初期化ベクター
	 * @param  secretKey     暗号化キー
	 * @return               暗号化されたバイト
	 */
	public static void main(String[] args) {
		
		String value = "HashValueだよ";
		String sha256 = "";
		
		// Java 標準 でのやり方
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] result = digest.digest(value.getBytes());
			sha256 = String.format("%040x", new BigInteger(1, result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("MessageDigest");
		System.out.println(sha256);
	}

}
