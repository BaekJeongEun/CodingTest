package Programmers;

import java.util.HashMap;

public class Camouflage {

	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } }));
		System.out.println(solution(new String[][] { { "crow_mask", "face" }, { "blue_sunglasses", "face" },
			{ "green_turban", "face" } }));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		
			for (Integer i : map.values()) {
				answer *= (i+1);
			}
		

		return answer-1;
	}
}
