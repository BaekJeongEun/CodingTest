package BaekJoon;

import java.util.Scanner;

public class BaekJoon2436 { // 공약수 (G5)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long gcd = sc.nextInt();
		long lcm = sc.nextInt();
		long N = gcd*lcm;
		long i=0, min=Long.MAX_VALUE, temp, a=gcd, b=lcm;
		for(i=2*gcd; i*i<N; i+=gcd) {
			if(N%i==0) {
				temp = N/i;
				
				if(gcd(i, temp) == gcd) {
					if(a+b > i + temp) {
						a = i;
						b = temp;
					}
				}
			}
		}
		
		System.out.println(a+" "+b);
	}

	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	
}
