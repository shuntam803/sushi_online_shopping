package chapter00;


/**
 * ステータスを更新してる風のコード
 *
 */
public class DungStatusChange {
	public static void main(String[] args) {
		// 50文字まで#を表示する
		int x = 50;
		// カウントアップする変数
		int y = 0;
		while(true) {
			if(x != y) {
				// 上限まで#を足していく
				System.out.print("#");
			}else {
				// 50文字になったら「 done!! + 改行」を出力し何かが終わった感を演出
				System.out.println(" done!! ");
				// カウントアップをリセット
				y = -1;
			}
			
			// カウントアップしていく
			y++;
			// 高速で出力すると捨て機関が出ないので出力待ち時間を作成する
			int sleepTime = 10;
			// ランダム値にマッチすると待ち時間をさらに長くする
			// 何かが大きな処理をしているように見えること請け合い
			int osooso = (int)(Math.random() * 6);
			if(4 < osooso && osooso <= 6) {
				sleepTime = 80;
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