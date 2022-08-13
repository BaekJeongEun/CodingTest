package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaekJoon1484 { // 다이어트 (G4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long start=1, end=1;
		boolean exit = false;
		while(true) {
			if(Math.pow(end, 2) - Math.pow(start, 2) < N) {
				end++;
			}
			else if(Math.pow(end, 2) - Math.pow(start, 2) == N) {
				System.out.println(end);
				exit = true;
				end++;
			}
			else if(Math.pow(end, 2) - Math.pow(start, 2) > N) {
				start++;
			}
			if(end-start==1 && Math.pow(end, 2)-Math.pow(start, 2)>N) break;
		}
		System.out.println(exit?"":"-1");
	}

}
