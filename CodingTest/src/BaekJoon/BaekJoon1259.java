package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1259 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = null;
		int cnt = 0;

		while (!(a = br.readLine()).equals("0")) {
			cnt = 0;

			for (int i = 0; i < a.length() / 2; i++) {
				if (a.charAt(i) == a.charAt(a.length() - i - 1)) {
					cnt++;
				}
			}
			if (cnt == a.length() / 2) {
				System.out.println("yes");
			} else
				System.out.println("no");

		}
	}

}
