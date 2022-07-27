package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon14568 { // 2017 연세대학교 프로그래밍 경시대회

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for(int a =2; a<=N-4; a+=2) {
			for(int b=1; b<=N-5; b++) {
				for(int c=b+2; c<=N-3; c++) {
					if(a+b+c == N) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
