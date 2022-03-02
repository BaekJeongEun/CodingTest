package BaekJoon;
// 피보나치 함수, 실버 3
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1003_ {
	static int zero=0, one=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int arr[] = new int[TC];
		zero=one=0;
		for(int i=0; i<TC; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			int n = fibonacci(arr[i]);
			System.out.println(zero+" "+one);
		}
	}
	public static int fibonacci(int n) {
		if(n==0) {
			zero++;
			return 0;
		}
		else if(n==1) {
			one++;
			return 1;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}

//package BaekJoon;
//// 피보나치 함수, 실버 3
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class BaekJoon1003_ {
//	static int zero=0, one=0;
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int TC = Integer.parseInt(br.readLine());
//		int arr[] = new int[TC];
//		
//		for(int i=0; i<TC; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//			int n = fibonacci(arr[i]);
//			System.out.println(zero+" "+one);
//			zero=one=0;
//		}
//	}
//	public static int fibonacci(int n) {
//		if(n==0) {
//			zero++;
//			return 0;
//		}
//		else if(n==1) {
//			one++;
//			return 1;
//		}
//		else {
//			return fibonacci(n-1) + fibonacci(n-2);
//		}
//	}
//}
