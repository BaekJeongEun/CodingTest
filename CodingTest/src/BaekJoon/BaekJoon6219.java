package BaekJoon;

import java.util.Scanner;

public class BaekJoon6219 {

	public static void main(String[] args) { // 소수의 자격 (S3)
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int D = sc.nextInt();
		int cnt = 0;
		for(int i=A; i<=B; i++) {
			// 소수인지
			if(isPrime(i) && Integer.toString(i).contains(Integer.toString(D))) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	private static boolean isPrime(int n) {
		boolean prime = true;
		
		for(int i=2; i*i<=n; i++) {
			if(n%i==0) {
				prime = false;
				break;
			}
		}
		
		return prime;
	}

}
