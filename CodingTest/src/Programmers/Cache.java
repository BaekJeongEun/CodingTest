package Programmers;

import java.util.ArrayList;
import java.util.Stack;

public class Cache { // 1차 캐시

	public static void main(String[] args) {
		System.out.println(solution(3,
				new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" }));
	}

	static public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		ArrayList<String> cache = new ArrayList<>();
		for (int i = 0; i < cities.length; i++) {
			if (cache.contains(cities[i])) {
				cache.remove(cities[i]);
				cache.add(cities[i]);
				answer += 1;
			} else {
				if(cache.size()==cacheSize) {
					cache.remove(0);
				}
				cache.add(cities[i]);
				answer += 5;
			}
		}
		return answer;
	}
}
