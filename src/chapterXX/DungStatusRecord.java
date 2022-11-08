package chapterXX;

public class DungStatusRecord {
	public static void main(String[] args) {
		// 50文字まで#を表示する
		int x = 0;
		int pre_x = -1;

		while (true) {

			int add = 0;

			if (x > pre_x) {
				add = x < 5 ? 1 : -1;
			} else {
				add = x <= 1 ? 1 : -1;
			}
			
			pre_x = x;
			x += add;
			
			// ランダム値にマッチすると待ち時間をさらに長くする
			// 何かが大きな処理をしているように見えること請け合い
			int ageage = (int) (Math.random() * 10);
			int ume = 10;

			if (ageage == x) {
				ume = 50;
			}
			
			String fmt = "%" + (x + ume) + "s";
			System.out.println(String.format(fmt, "*").replace(" ", "*"));
			
			try {
				// 待ち時間
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}