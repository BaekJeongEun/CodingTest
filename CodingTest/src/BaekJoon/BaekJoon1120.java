package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1120 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int min = 100, cnt=0;
		String str[];
		str = br.readLine().split(" ");

		for (int i = 0; i < str[1].length() - str[0].length() + 1; i++) { 
			cnt=0;
			for (int j = 0; j < str[0].length(); j++) {
				if (str[0].charAt(j) != str[1].charAt(j+i)) {
					cnt++;
				}
			}
			if(cnt < min)
				min = cnt;

		}
		System.out.println(min);
	}

}
