package chapterXX;

import java.util.HashMap;
import java.util.Map;

public class Map_EntryExample {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(115, "田中");
		map.put(120, "木村");
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
	}

}
