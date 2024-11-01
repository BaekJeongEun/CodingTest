package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeAttack { // 나무 공격 (L2)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0, angel = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					total++;
				}
			}
		}
		int[] window = new int[N];
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken())-1;
			int R = Integer.parseInt(st.nextToken())-1;
			for(int j=L; j<=R; j++) {
				window[j]++;
			}
		}
		
		for(int j=0; j<M; j++) { 
			for(int i=0; i<N; i++) {// 고정
				if(arr[i][j] > 0 && window[i] > 0) {
					arr[i][j]--;
					window[i]--;
					angel++;
				}
			}
		}
		System.out.println(total - angel);
	}

}
