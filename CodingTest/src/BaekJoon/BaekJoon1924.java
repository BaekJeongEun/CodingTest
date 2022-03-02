package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1924 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int month[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		String day[] = {"MON", "TUE","WED", "THU", "FRI","SAT","SUN"};
		int sum = 0;
		
		for(int i=0; i<x-1; i++) {
			sum += month[i];
		}
		sum = sum + y -1;
		
		bw.write(day[sum%7]);
		bw.flush();
		bw.close();
	}

}
