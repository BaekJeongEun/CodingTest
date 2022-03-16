package BaekJoon;

import java.util.Scanner;

public class BaekJoon1075 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int F = sc.nextInt();
		// 뒤 두자리 수를 00으로 바꿔주는 과정
		N -= (N % 100);

		// 무한루프
		while (true) {
			// 나누어떨어지면 무한루프 종료
			if (N % F == 0) {
				break;
			}
			N++;
		}
		System.out.format("%02d", (N % 100));
	}
}