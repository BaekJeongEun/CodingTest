package BaekJoon;

import java.util.Scanner;

public class BaekJoon15736 { // 청기 백기 (S4)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), cnt=0;
		
		for(int i=1; i*i<=N; i++) {
			cnt++;
		}
		
		System.out.println(cnt);
	}

}