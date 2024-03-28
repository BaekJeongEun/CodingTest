package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaseSequenceCover {
	static int N, M, count;
	static char[][] arr;
	static char[] pick, sequence = {'a','c','g','t'};
	static HashMap<String, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		pick = new char[M];
		map = new HashMap<>();
		comb(0);
		System.out.println(map.size());
	}
	private static void comb(int cnt) {
		if(cnt == M) {
			count = 0;
			if(valid()) {
				map.put(String.valueOf(pick), count);
			}
			return;
		}
		for(int i=0; i<4; i++) {
			pick[cnt] = sequence[i];
			comb(cnt+1);
		}
	}
	private static boolean valid() {
		for(int i=0; i<N; i++) {
			boolean success = true;
			for(int j=0; j<M; j++) {
				if(arr[i][j] != '.' && (arr[i][j] != pick[j])) {
					success = false;
				}
			}
			if(success) {
				count++;
			}
		}
		return count==0?false:true;
	}
}
