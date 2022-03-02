package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num=N, cycle=0;
		while(true) {
			if(cycle==0)
				num=N;
			int remainder = num%10;
			int quotient = num/10;
			
			int sum = remainder + quotient;
			
			num = remainder*10 + (sum%10);
			
			cycle++;
			if(num == N)
				break;
		}
		System.out.println(cycle);
	}

}
