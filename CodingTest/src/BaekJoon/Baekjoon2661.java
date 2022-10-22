package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2661 { // 좋은수열 (G4)
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		comb(1, "1");
	}

	private static void comb(int cnt, String str) {
		if (cnt == N) {
			System.out.println(str);
			System.exit(0);
		}
		int cur = str.charAt(str.length() - 1) - 48;
		for (int i = 1; i <= 3; i++) {
			if (i != cur) {
				if (check(str + "" + i)) {
					comb(cnt + 1, str + "" + i);
				}
			}
		}
	}

	private static boolean check(String str) {
		int len = str.length();
		int loop = len/2;
		int start = len-1;
		int end = len;
		
		for(int i=1; i<=loop; i++) {
			if(str.substring(start-i, end-i).equals(str.substring(start, end))) {
				return false;
			}
			start--;
		}
		
		return true;
	}

}