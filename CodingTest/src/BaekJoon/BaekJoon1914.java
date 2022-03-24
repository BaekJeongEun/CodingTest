package BaekJoon;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon1914 {
	static int cnt, N;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		sb.append((int)(Math.pow(2, N) - 1)).append("\n");
		if(N<=20) {
			hanoi(N,1,2,3);
		}
		System.out.println(sb.toString());
	}
	
	public static void hanoi(int n, int from, int temp, int to) {
		if(n==1) {
			sb.append(from+" "+to+"\n");
			return;
		}
		hanoi(n-1, from, to, temp);
		sb.append(from+" "+to+"\n");
		hanoi(n-1, temp, from, to);
	}
}
//
//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class BaekJoon1914 {
//	static int cnt, N;
//	static StringBuilder sb;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		sb = new StringBuilder();
//		N = sc.nextInt();
//		BigInteger bigInt = new BigInteger("1");
//		if(N<=20) {
//			sb.append((int)(Math.pow(2, N) - 1)).append("\n");
//			hanoi(N,1,2,3);
//		}
//		else {
//			for(int i=0; i<N; ++i) {
//				bigInt = bigInt.multiply(new BigInteger("2")); // 2의 N 제곱
//            }
//			bigInt = bigInt.subtract(new BigInteger("1")); // 빼기 1
//            sb.append(bigInt).append("\n");
//		}
//		System.out.println(sb.toString());
//	}
//	
//	public static void hanoi(int n, int from, int temp, int to) {
//		if(n==0) return;
//		hanoi(n-1, from, to, temp);
//		sb.append(from+" "+to+"\n");
//		hanoi(n-1, temp, from, to);
//	}
//}