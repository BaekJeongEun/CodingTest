package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon2869 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String arr[] = br.readLine().split(" ");
		
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int v = Integer.parseInt(arr[2]);
		int result = 0;
		
		if((v-b)%(a-b)!=0) {
			result = (v-b)/(a-b) + 1;
		}
		else
			result = (v-b)/(a-b);
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

}
