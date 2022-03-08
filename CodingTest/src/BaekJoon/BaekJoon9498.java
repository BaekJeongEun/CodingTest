package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9498 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());
		char result = 'a';
		if(score>=90) {
			result = 'A';
		}else if(score>=80) {
			result = 'B';
		}else if(score>=70) {
			result = 'C';
		}else if(score>=60) {
			result = 'D';
		}else
			result = 'F';
		System.out.println(result);
	}
}
