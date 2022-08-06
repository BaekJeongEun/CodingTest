package BaekJoon;

import java.util.Scanner;

public class BaekJoon15996 { //팩토리얼 나누기 (S4)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int A = sc.nextInt();
		int cnt = 0;
		for(int i=A; N/i>=1; i*=A) {
			cnt += N/i;
		}
		System.out.println(cnt);
	}

}
