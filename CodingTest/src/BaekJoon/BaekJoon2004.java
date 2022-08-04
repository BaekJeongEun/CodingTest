package BaekJoon;

import java.util.Scanner;

public class BaekJoon2004 { // 조합 0의 개수 (S2)
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		long n = sc.nextLong();
		long m = sc.nextLong();
		long n_m = n-m;
		
		long a = get(5, n) - get(5, n_m) - get(5, m);
		long b = get(2, n) - get(2, n_m) - get(2, m);
		
		System.out.println(Math.min(a, b));

	}
	
	private static long get(long loop, long n) {
		
		long cnt=0;
		while(n >= loop) {
			cnt += n/loop;
			n /= loop;
		}
		//for(long i=loop; i<=n; i*=loop) {
		//	cnt += n/i;
		//}
		return cnt;
	}
	

}