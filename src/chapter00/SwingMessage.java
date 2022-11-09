package chapter00;

import javax.swing.JOptionPane;

public class SwingMessage {

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			try {
				"Hello".charAt(-1);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "処理中にエラーが発生しました。");
			}
		}
		
	}
}
