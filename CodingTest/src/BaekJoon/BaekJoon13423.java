package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon13423 { // Three dots (S2)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine()), total=0;
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					int dist = Math.abs(arr[j]-arr[i])+arr[j]; 
					int s = i, e = N-1;
					while(s<=e) {
						int mid = (s+e)/2;
						if(arr[mid] > dist) { // 예상보다 크다면 줄여야 함
							e = mid - 1;
						}else if(arr[mid] < dist) {
							s = mid + 1;
						}else{
							total++;
							break;
						}
					}
				}
			}
			System.out.println(total);
		}

	}

}
