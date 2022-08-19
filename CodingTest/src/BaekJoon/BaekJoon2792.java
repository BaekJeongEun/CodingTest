package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2792 { // 보석 상자(S2)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[M], max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int start = 1, end = max;
		// 0개부터 최대 나눠줄 수 있는 개수까지 탐색
		while(start<=end) {
			int mid = (start+end)/2, cnt=0;
			// 구슬을 mid만큼 나눠줬을 때 학생수 넘치지 않아야 함
			for(int i=0; i<M; i++) {
				cnt += arr[i]/mid;
				if(arr[i]%mid!=0) cnt++;
			}
			if(cnt <= N) {
				end = mid-1;
				min = Math.min(min, mid);
			}else{
				start = mid+1;
			}
		}
		System.out.println(min);
	}

}
