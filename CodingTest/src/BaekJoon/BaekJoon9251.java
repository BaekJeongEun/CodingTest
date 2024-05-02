package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9251 { // LCS (G5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string1 = br.readLine().toCharArray();
		char[] string2 = br.readLine().toCharArray();
		int[][] dp = new int[string1.length+1][string2.length+1];
		for(int i=1; i<=string1.length; i++) {
			for(int j=1; j<=string2.length; j++) {
				if(string1[i-1] != string2[j-1]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}else {
					dp[i][j] = dp[i-1][j-1]+1;
				}
			}
		}
		System.out.println(dp[string1.length][string2.length]);
	}

}
