package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon17074 { // 정렬(S2)

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = -1, cnt = 0, result = N;
		int arr[] = new int[N+2];
		arr[0] = Integer.MIN_VALUE;
		arr[N+1] = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] < arr[i-1]) {
				cnt++;
				idx = i;
			}
		}
		if(cnt > 1) {
			result = 0;
		}else if(cnt == 1) {
			int ans = 0;
			if(arr[idx-1] <= arr[idx+1]) ans++;
			if(arr[idx-2]<=arr[idx]) ans++;
			result = ans;
		}
		System.out.println(result);
	}

}
