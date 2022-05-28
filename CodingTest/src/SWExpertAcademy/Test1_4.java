package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1_4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			int arr[] = new int[people];
			float avg, sum=0;
			for(int i=0; i<arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum+=arr[i];
			}
			avg = sum/arr.length;
			float overAvg = 0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > avg) {
					overAvg++;
				}
			}
			System.out.printf("#"+(tc+1)+" %.3f"+"%%\n", (overAvg/arr.length*100));
		}

	}

}
