package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon3040 { // 백설 공주와 일곱 난쟁이(B2)
	static int[] input = new int[7];
	static int[] arr = new int[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
	}

	private static void comb(int idx, int cnt) {
		if(cnt == 7) {
			int sum = Arrays.stream(input).sum();
			if(sum==100) {
				for(int i=0; i<7; i++) {
					System.out.println(input[i]);
				}
			}
			return;
		}
		for(int i=idx; i<9; i++) {
			input[cnt] = arr[i];
			comb(i+1, cnt+1);
		}
	}
}