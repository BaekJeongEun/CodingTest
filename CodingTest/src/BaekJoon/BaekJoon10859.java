package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10859 { // 뒤집어진 소수 (S2)
	static long num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer = "yes";

		num = Long.parseLong(String.valueOf(str));
		if (num==1 || str.contains("3") || str.contains("4") || str.contains("7")) { // 이 숫자 들어가면 안됨
			answer = "no";
		} else {
			if (!isPrime(num)) { // 원래 수도 소수 아님
				answer = "no";
			} else if (!isPrime(rotation(str))) {
				answer = "no";
			}
		}
		System.out.println(answer);
	}

	private static long rotation(String str) {
		StringBuffer sb = new StringBuffer(str);
		String reversedStr = sb.reverse().toString();
		
		reversedStr = reversedStr.replace("6", ".");
		reversedStr = reversedStr.replace("9", "6");
		reversedStr = reversedStr.replace(".", "9");

		return Long.parseLong(reversedStr);
	}

	private static boolean isPrime(long n) {
		boolean prime = true;
		// 들어온 수가 소수인지
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}

}
