package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1003 {
	static int zero[], one[];
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		zero=new int[41]; one=new int[41];
		arr = new int[TC];
		for(int i=0; i<TC; i++) {
			arr[i] = Integer.parseInt(br.readLine());	
		}
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		
		for(int i=2; i<41; i++) {
			zero[i] = zero[i-1] + zero[i-2];
			one[i] = one[i-1] + one[i-2];
		}
		for(int i=0; i<TC; i++) {
			System.out.println(zero[arr[i]]+" "+one[arr[i]]);
		}
	}
}