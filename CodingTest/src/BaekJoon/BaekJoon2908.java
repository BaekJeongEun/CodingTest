package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// »ó¼ö
public class BaekJoon2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

		bw.write(String.valueOf((a>b)?a:b));
		bw.flush(); 
		bw.close();
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 * 
		 * String str = br.readLine();
		 * 
		 * String arr[] = str.split("");
		 * 
		 * int a = Integer.parseInt(arr[2]+arr[1]+arr[0]); int b =
		 * Integer.parseInt(arr[6]+arr[5]+arr[4]);
		 * 
		 * bw.write(String.valueOf((a>b)?a:b)); bw.flush(); bw.close();
		 */
	}

}
