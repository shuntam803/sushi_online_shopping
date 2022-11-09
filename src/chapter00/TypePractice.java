package chapter00;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TypePractice {

	public static void main(String[] args) throws IOException {
		// 変数置き場
		
		String str;
		String kknn;
		int kazu;
		int kaisu;
		int seikai = 0;
		double temp;
		double hyouka;
		
		// Javaの起動がおかしかった時の表示
		if (args.length != 1) {
			System.out.println("ファイル名を正しく指定してください。");
			System.exit(1);
		}
		
		// 問題を読み込む配列の作成とファイルリーダー起動
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String[] mondai = new String[50];
		
		// 配列mondaiにファイル内の単語を読み込ませる
		for (int i = 0; i < mondai.length; i++) {
			str = br.readLine();
			mondai[i] = str;
			
		}
		
		// ファイルリーダーを閉じる
		br.close();
		
		// オープニング
		System.out.println("これからタイピングの練習を行います。");
		
		// 問題数を入力してもらい、変数kaisuに格納する
		System.out.println("何問やりますか？");
		br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		kaisu = Integer.parseInt(str);
		
		// ゲーム開始
		System.out.println("それでは準備をしてください。");
		
		// カウントダウン
		for (int s = 5; s >= 0; s--) {
			try {
				Thread.sleep(1000);
				System.out.println(s);
			} catch (InterruptedException e) {
				
			}
		}
		
		// タイピング練習開始
		System.out.println("今から表示される文字をタイピングしてください");
		
		for (int i = 1; i <= kaisu; i++) {
			
			// 変数kazuにランダム変数を用いて0-49の数字を格納する
			kazu = (int)(Math.random() * 50);
			
			// 視認性を上げるための改行
			System.out.println();
			
			// 配列mondaiに格納された文字の表示
			System.out.println(mondai[kazu]);
			
			// 打ち込まれた内容を変数strに入れる
			br = new BufferedReader(new InputStreamReader(System.in));
			str = br.readLine();
			
			// 判定
			kknn = new String(mondai[kazu]);
			if (kknn.equals(str) == true) {
				System.out.println("正解です");
				seikai++;
			} else {
				System.out.println("次\n頑\n張\nり\nま\nし\nょ\nう\n");
			}
		}
		
		// 正答率の表示
		System.out.println("正答率は" + seikai + "/" + kaisu + "です");
		
		// 小数点以下を表示するために変数の型変更
		temp = kaisu * 1.0;
		
		// 正答率を変数hyoukaに格納	
		hyouka = seikai / temp;
		
		// 正答率をもとに評価を表示
		if (hyouka >= 0.8) {
			System.out.println("頑張ってますね");
		} else if (hyouka >= 0.5) {
			System.out.println("もう少しできるようになるといいですね");
		} else {
			System.out.println("伸びしろがいっぱいですね");
		}

	}

}
