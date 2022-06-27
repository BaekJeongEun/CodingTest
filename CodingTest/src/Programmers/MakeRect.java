package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MakeRect {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][] {{1,4},{3,4},{3,10}})));
	}
	public static int[] solution(int[][] v) {
		int[] answer = new int[2];
		HashMap<Integer, Integer> mapX = new HashMap<>();
		HashMap<Integer, Integer> mapY = new HashMap<>();
		for(int i=0; i<3; i++) {
			mapX.put(v[i][0], mapX.getOrDefault(v[i][0], 0)+1);
			mapY.put(v[i][1], mapY.getOrDefault(v[i][1], 0)+1);
		}
		for(Integer key: mapX.keySet()) {
			if(mapX.get(key)==1) {
				answer[0] = key;
			}
		}
		for(Integer key: mapY.keySet()) {
			if(mapY.get(key)==1) {
				answer[1] = key;
			}
		}
		return answer;
	}
}