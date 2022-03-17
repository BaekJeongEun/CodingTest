package BaekJoon;

import java.util.Scanner;

public class BaekJoon10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(rec(N));
	}
	static int rec(int n) {
		return (n<=1)?1:rec(n-1)*n;
	}
}

/* 피보나치
package BaekJoon;

import java.util.Scanner;

public class BaekJoon10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(rec(N));
	}
	static int rec(int n) {
		if(n==0) return 0;
		return (n<=2)?1:rec(n-1)+rec(n-2);
	}
}
*/