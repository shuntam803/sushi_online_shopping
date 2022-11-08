package chapterXX;


/**
 * 数字の羅列を出力し、何かを自動で作っている風のコード
 *
 */
public class DungCompiler {
	public static void main(String[] args) {
		while(true) {
			// カウントアップ
			int x = 1;
			// 出力文字列
			String code = "";
			while (true) {
				// 0から9までの数値をランダムで出力
				int num = (int)(Math.random() * 9);
				// 出力文字列に足していく
				code += String.valueOf(num);
				if ( x == 50) {
					// 50文字でブレイク
					break;
				}
				x++;
			}
			
			// 数値の羅列を出力：いい感じにコンパイルしてる感が出る
			System.out.println(code);
		
			// 高速で出力すると捨て機関が出ないので出力待ち時間を作成する
			int sleepTime = 10;
			// ランダム値にマッチすると待ち時間をさらに長くする
			// 何かが大きな処理をしているように見えること請け合い
			int randum = (int)(Math.random() * 10);
			if(4 < randum && randum <= 6) {
				sleepTime = 500;
			}
			try {
				// 待ち時間
				Thread.sleep(sleepTime);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}