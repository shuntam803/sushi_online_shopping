package chapterXX;

public class Slot {

	public static void main(String[] args) {
		
		int slotArray[] = new int[3];
		for (int i = 0; i < 3; i++) {
			slotArray[i] = (int) (Math.random() * 10);
			System.out.print(slotArray[i]);
			
		}
		if (slotArray[0] == slotArray[1] && slotArray[0] == slotArray[2]) {
			if (slotArray[0] == 7) {
				System.out.println();
				System.out.println("大当たり");
			} else {
				System.out.println();
				System.out.println("当たり");

			}
		} else {
			System.out.println();
			System.out.println("もう一回");

		}
	}

}
