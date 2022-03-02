package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2577 {

	public static void main(String[] args) throws IOException{
		int arr[] = new int[10];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int mul = a*b*c;
		String result = Integer.toString(mul);
		
		for(int i=0; i<result.length(); i++) {
			arr[Character.getNumericValue(result.charAt(i))]++;
		}
		for(int i=0; i<10; i++) {
			System.out.println(arr[i]);
		}
	}
}