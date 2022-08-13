package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
public class BaekJoon16472 { // 고냥이(G4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		String input = br.readLine();
		
		int start = 0, end = 0, length = 1, max=Integer.MIN_VALUE;
		String current = null;
		map.put(input.charAt(end)+"", 1);
		
		while(end<input.length()-1) {
			
			if(map.size() <= N) {
				end++;
				length++;
				current = input.charAt(end)+"";
				map.put(current, map.getOrDefault(current, 0)+1);
			}
			if(map.size() > N) {
				current = input.charAt(start)+"";
				start++;
				length--;
				map.put(current, map.get(current)-1);
			}
			if(map.get(current)==0) map.remove(current);
			
			max = Math.max(max, length);
		}
		
		System.out.println(max);
	}

}
