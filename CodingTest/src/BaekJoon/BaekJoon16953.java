package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16953 { // A → B(S2)
	static long A, B, answer = -1;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		dfs(A, 0);
		System.out.println(answer);
	}
	private static void dfs(long num, long cnt) {
		String strNum = num+"";
		if(num == B) {
			answer = cnt + 1;
		}
		long concat1 = Long.parseLong(strNum+"1");
		long mul2 = num * 2;
		if(concat1 <= B) {
			dfs(concat1, cnt+1);
		}
		if(mul2 <= B) {
			dfs(mul2, cnt+1);
		}
	}

}
