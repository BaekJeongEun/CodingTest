package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaekJoon1407 { // 2로 몇 번 나누어질까 (G4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//long A = sc.nextLong();
		long B = sc.nextLong();
		
		System.out.println(num(B));
		//System.out.println(num(B) - num(A-1));
	}

	private static long num(long N) {
		long cnt = N;
		for(long i=2; i<=N; i*=2) {
			cnt += (N/i)*(i/2);
		}
		return cnt;
	}

}
