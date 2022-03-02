package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpertAcademy1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dump;
		int[] arr = new int[100];
		StringTokenizer st;
		
		for(int TC=0; TC<10; TC++) {
			
			dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for(int tc=0; tc<100; tc++) {
				arr[tc] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for(int i=0; i<dump; i++) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			System.out.println("#"+(TC+1)+" "+(arr[99]-arr[0]));
		}
	
	}
	
}
