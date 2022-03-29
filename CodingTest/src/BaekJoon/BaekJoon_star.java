package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_star {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		System.out.println(a/b);
		
//		int N = Integer.parseInt(br.readLine());
//		
//		for(int i=1; i<=N; i++) {
//			System.out.println(i);
//		}
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<i+1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				if(j<N-i-1)
//					System.out.print(" ");
//				else
//					System.out.print("*");
//			}
//			System.out.println();
//		}
	}
}
