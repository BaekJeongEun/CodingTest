package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10250 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		String arr[];
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<TC; tc++) {
			arr = br.readLine().split(" ");
			int floor = Integer.parseInt(arr[2])%Integer.parseInt(arr[0]);
			if(floor==0) {
				floor = Integer.parseInt(arr[0]);
			}
			sb.append(String.valueOf(floor));
			int ho = Integer.parseInt(arr[2])/Integer.parseInt(arr[0])+1;
			if(Integer.parseInt(arr[2])%Integer.parseInt(arr[0])==0) ho-=1;
			if(ho<10) {
				sb.append(0).append(ho);
			}
			else
				sb.append(ho);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}