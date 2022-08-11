package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1010 {

	static int[][] memo; // 여러 번 중복 호출 방지를 위해 nCr 값을 저장
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			memo = new int[m+1][n+1];
			
			// M개 중 N개를 뽑는 조합의 경우의 수
			System.out.println(nCr(m,n));
		}
	}

	/**
	 *  n개 중 r개를 뽑는 조합의 경우의 수 반환
	 *  @param n 고려할 요소의 개수
	 *  @param r 뽑을 요소의 개수
	 *  @return
	 */
	private static int nCr(int n, int r) {
		if(memo[n][r]>0) return memo[n][r];
		// 뽑을 요소의 개수와 전체 요소의 개수가 같은 경우나
		// 뽑을 요소의 개수가 0개라면 1 반환    
		if(n == r || r==0) return 1;
		
		return memo[n][r] = nCr(n-1, r-1) + nCr(n-1, r);
	}
}
