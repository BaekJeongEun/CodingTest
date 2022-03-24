package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1018 {
	static int N, M, cnt, min=100;
	static String arr[][], wStart="WBWBWBWB", bStart="BWBWBWBW";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N][M];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().split("");
		}
		for(int i=0; i<N-8+1; i++) {
			for(int j=0; j<M-8+1; j++) {
				int temp = check(i, j);
				min = min>temp?temp:min;
			}
		}
		System.out.println(min);
	}
	private static int check(int x, int y) {
		int wStartCnt=0, bStartCnt=0, index=0;
		for(int i=x; i<x+8; i++) {
			index=0;
			for(int j=y; j<y+8; j++, index++) {
				// w로 시작
				// 짝수행일 경우 W로 시작
				if(i%2==0 && !arr[i][j].equals(String.valueOf(wStart.charAt(index)))) {
					wStartCnt++;
				}
				// 홀수행일 경우 B로 시작
				if(i%2!=0 && !arr[i][j].equals(String.valueOf(bStart.charAt(index))))
					wStartCnt++;
				
				// B로 시작
				// 짝수행일 경우 B로 시작
				if(i%2==0 && !arr[i][j].equals(String.valueOf(bStart.charAt(index))))
					bStartCnt++;
				// 홀수행일 경우 W로 시작
				if(i%2!=0 && !arr[i][j].equals(String.valueOf(wStart.charAt(index))))
					bStartCnt++;
			}
		}
		return Math.min(wStartCnt, bStartCnt);
	}
}
