package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon22862 { // 가장 긴 짝수 연속한 부분 수열 (large) (G5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int end=0, start = 0, max = 0, cnt = (arr[0]%2!=0)?1:0;
		
		while(true) {
			while(end < N-1) {
				if(arr[end+1]%2!=0) { // 홀수이면
					if(K>cnt) cnt++; // 지울 수 있으면 지우고
					else break; // 아니면 말고..
				}
				end++;
			}
			if(start>=N || end>= N) break;
			max = Math.max(max, end-start+1-cnt);
			if(arr[start]%2!=0) cnt--;
			start++;
		}
		System.out.println(max);
	}
}