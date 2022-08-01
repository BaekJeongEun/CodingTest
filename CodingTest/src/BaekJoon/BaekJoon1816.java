package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		for(long i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			boolean isPrime = true;
			for(long n=2; n<=1000000; n++) {
				if(num % n == 0) {
					isPrime = false;
				}
			}
			System.out.println((isPrime)?"YES":"NO");
		}
	}

}
