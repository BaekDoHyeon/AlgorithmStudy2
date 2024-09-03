package 알고리즘_강의.kostaAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Count {

	public String execute(String book) {
		Map<String, Integer> maps = new HashMap<>();
		String result = "";
		int maxCnt = Integer.MIN_VALUE;
		String[] arr = book.toLowerCase().split(" ");

		//값 저장
		for (int i = 0; i < arr.length; i++)
			maps.put(arr[i], maps.getOrDefault(arr[i], 0) + 1);

		for (String key : maps.keySet()) {
			int cnt = maps.get(key);

			// key의 알파벳이 result 보다 앞서 있다면 음수 반환 -> result 가 앞서 있다면 양수 반환
			if (cnt > maxCnt || (cnt == maxCnt && key.compareTo(result) < 0)) {
				maxCnt = cnt;
				result = key;
			}
		}
		
		return result;
	}

 public static void main(String[] args) {
	String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. ";
	String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
	String book3 ="I like cat. I like cat. I like cat. ";
	Count c = new Count();

	System.out.println(c.execute(book1));
	System.out.println(c.execute(book2));
	System.out.println(c.execute(book3));
	}
}
