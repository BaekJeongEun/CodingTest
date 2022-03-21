package BaekJoon;

import java.util.Scanner;

public class BaekJoon2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i=1, sum=1;
		for(i=1; ; i++) {
			if(sum >= N)
				break;
			sum += i*6;
		}
		System.out.println(i);
	}
}
