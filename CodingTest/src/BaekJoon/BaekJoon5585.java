package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon5585 { // 거스름돈 (B2)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cost = 1000 - Integer.parseInt(br.readLine());
		int[] arr = {500, 100, 50, 10, 5, 1};
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			result += cost/arr[i];
			cost %= arr[i];
		}
		System.out.println(result);
	}
}
