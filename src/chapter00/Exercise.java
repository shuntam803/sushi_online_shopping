package chapter00;

class Animal {
	public String Name;
	public int Age;

	public void ShowProfile() {
		System.out.println("名前は" + Name + "、" + Age + "歳です。");
	}
}

class Cat extends Animal {
	public void Sleep() {
		System.out.println("スースー");
	}
}

public class Exercise {
	public static void main(String[] args) {

		Cat MyCat = new Cat();

		MyCat.Name = "たま";
		MyCat.Age = 3;
		MyCat.ShowProfile();
		MyCat.Sleep();

		int[][][] enemyImage = 
				{ { { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
						{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
						{ 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
						{ 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
						{ 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 } },
						{ { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
								{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
								{ 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
								{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
								{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
								{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1 } },
						{ { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
								{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
								{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
								{ 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
								{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
								{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 } } };
		
		for(int[][] img : enemyImage) {
			for(int[] line : img) {
				for(int dot : line) {
					if(dot == 1) {
						System.out.print("#");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}

	}
}