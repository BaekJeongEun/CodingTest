package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BaekJoon2015 { // 수들의 합 4 (G4)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = 0;
		int[] arr = new int[N];
		int[] sum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i+1] = sum[i] + arr[i];
			if(sum[i+1] == K) result++;
			if(map.containsKey(sum[i+1]-K)) result += map.get(sum[i+1]-K);
			map.put(sum[i+1], map.getOrDefault(sum[i+1], 0)+1);
		}
		System.out.println(result);
	}

}
