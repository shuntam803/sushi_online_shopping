package chapter00;

import java.util.stream.Stream;

public class Zundoko {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		Stream.generate(() -> sb.append(Math.random() < 0.5 ? "ズン" : "ドコ")).anyMatch(s -> s.toString().endsWith("ズンズンズンズンドコ"));
		System.out.println(sb + "キ・ヨ：シ！");
		
		
	}

}
