package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon15593 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE, cnt=0;
		int[] arr = new int[1001];
		
		int[][] input = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			input[i][0] = start;
			input[i][1] = end-1;
		}
		
		for(int i=0; i<N; i++) {
			cnt=0;
			arr = new int[1001];
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				for(int k=input[j][0]; k<=input[j][1]; k++) {
					arr[k]++;
					if(arr[k]==1) {
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}
