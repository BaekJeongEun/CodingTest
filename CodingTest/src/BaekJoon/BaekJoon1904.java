package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1904 { // 01타일(S3)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		System.out.println(Tile(N));
 
	}
 
	public static int Tile(int a) {
 
		if (a == 1) {
			return 1;
		} 
 
		if (a == 2) {
			return 2;
		}
 
		int val1 = 1;
		int val2 = 2;
		int sum = 0;
 
		for (int i = 2; i < a; i++) {
			sum = (val2 + val1) % 15746;	
			val1 = val2;	 
			val2 = sum;		 
		}
 
		return sum;
 
	}

}
