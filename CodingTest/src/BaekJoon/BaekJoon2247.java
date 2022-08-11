package BaekJoon;

import java.util.Scanner;

public class BaekJoon2247 { // 실질적 약수 (G5)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt(), cnt=0;
		
		for(long i=1; i<=N; i++) {
			cnt += (N/i)*i; // i를 약수로 가지는 개수*i
		}
		cnt -= (N+N*(N+1)/2); // 나도 빼고 1도 빼기
		System.out.println(cnt%1000000+1);
	}

}
