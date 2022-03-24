package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int max5 = N/5;
		int max3 = N/3;
		
		int i, j, count=-1;
		
		for(j=max5; j>=0 && count==-1; j--) {
			for(i=0; i<= max3; i++) {
				if(i*3 + j*5 == N) {
					count = i+j;
					break;
				}
			}
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

}
