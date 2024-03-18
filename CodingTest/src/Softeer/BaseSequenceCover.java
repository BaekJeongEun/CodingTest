package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaseSequenceCover { // 염기서열 커버(L3)
	static int N, M;
	static char[][] arr;
	static char[] pick;
	static Set<String> set;
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
		set = new HashSet();
		comb(0, 0, 0);
		System.out.println(set.size());
	}
	private static void comb(int x, int y, int cnt) {
		if(cnt == M) {
			if(valid()) {
				set.add(String.valueOf(pick));
			}
			return;
		}
		for(int j=y; j<M; j++) {
			for(int i=x; i<N; i++) {
				if(arr[i][j] == '.') continue;
				pick[cnt] = arr[i][j];
				comb(i, j+1, cnt+1);
			}
		}
	}
	private static boolean valid() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] != '.' && arr[i][j] != pick[j]) {
					return false;
				}
			}
		}
		return true;
	}

}
