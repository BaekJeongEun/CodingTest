package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2562 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		
		arr[0]=Integer.parseInt(br.readLine());
		int max=arr[0], index=0;
		for(int i=1; i<9; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]>arr[index]) {
				max = arr[i];
				index = i;
			}
		}			
		System.out.println(max+"\n"+(index+1));
	}
}