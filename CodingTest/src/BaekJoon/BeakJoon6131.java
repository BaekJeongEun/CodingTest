package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon6131 { // 완전제곱수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int a=1; a<=500; a++) {
			for(int b=1; b<=500; b++) {
				if(Math.pow(a, 2) - Math.pow(b, 2) - N == 0 ) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
