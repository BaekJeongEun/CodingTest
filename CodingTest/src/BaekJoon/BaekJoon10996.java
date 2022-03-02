package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon10996 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int y = 1; y <= N*2; y++) {
			
			for (int x = 1; x <= N; x++) {
				if (x %2 == ((y % 2 == 0)? 1 : 0))
					bw.write(" ");
				else
					bw.write("*");
				
			}
			bw.write((y == N*2)? "" : "\n");
			
		}
		bw.flush();
		bw.close();
	}

}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<((n%2==0)?n/2:(n/2)+1); j++) {
				System.out.print("* ");
			}
			if(n!=1) {
				System.out.print("\n"+" ");
			}
			for(int j=0; j<n/2; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
*/