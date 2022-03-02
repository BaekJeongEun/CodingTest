package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15596 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		System.out.println(sum(arr));
	}
	
	static long sum(int[] a) {
		long sum=0;
		
		for(int i=0; i<a.length; i++) {
			sum+=a[i];
		}
		
		return sum;
	}
}
