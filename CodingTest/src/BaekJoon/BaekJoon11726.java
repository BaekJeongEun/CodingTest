package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[N]);
	}
	
	static int rec(int n) {
		if(n<2) return 1;
		else {
			return rec(n-1)+rec(n-2);
		}
	}
}
