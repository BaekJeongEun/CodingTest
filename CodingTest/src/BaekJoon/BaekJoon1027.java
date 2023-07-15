package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1027 { // 고층건물 (G4)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for(int idx=0; idx<N; idx++) {
			int count = 0;
			double temp = 0;
			for(int i=idx-1; i>=0; i--) {
				double gap = (double) (arr[idx]-arr[i])/(idx-i);
				if(i==idx-1 || temp>gap) {
					count++;
					temp = gap;
				}
			}
			for(int i=idx+1; i<N; i++) {
				double gap = (double) (arr[idx]-arr[i])/(idx-i);
				if(i==idx+1 || temp<gap) {
					count++;
					temp = gap;
				}
			}
			answer = Math.max(answer, count);
			System.out.println(answer);
		}
	}
}
