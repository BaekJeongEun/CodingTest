package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2747 {
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr =new int[n+1];
		int sum = 1;
		
		for(int i=0; i<n+1; i++)
			arr[i] = -1;
		
		arr[0]=0;
		arr[1]=1;
		
		System.out.println(fib(n));
	}
	
	public static int fib(int n) {
		if(arr[n]==-1)
			arr[n] = fib(n-1)+fib(n-2);
	
		return arr[n];
	}

}
