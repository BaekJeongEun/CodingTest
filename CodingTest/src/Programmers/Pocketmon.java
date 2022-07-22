package Programmers;

import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

public class Pocketmon {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,3,3,2,2,2}));
		
	}
	public static int solution(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for(int i : nums) {
        	map.put(i, map.getOrDefault(i, 0)+1);     	
        }
        int N_2 = nums.length/2;
        return (N_2 >= map.size())?map.size():N_2;
    }
}
