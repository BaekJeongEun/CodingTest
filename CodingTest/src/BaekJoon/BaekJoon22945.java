package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon22945 { // 팀빌딩(G4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = N-1, dist = Integer.MIN_VALUE, min=0;
		
		while(start<end) {
			min = Math.min(arr[start], arr[end]);
			dist = Math.max(dist, min*(end-start-1));
			if(arr[start]<arr[end]) {
				start++;
			}else end--;
		}
		System.out.println(dist);
	}

}
