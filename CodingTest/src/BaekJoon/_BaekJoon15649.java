package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _BaekJoon15649 {
	static int N, M, arr[], select[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];
		select = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		permutation(0,0);
	}
	private static void permutation(int index, int cnt) {
		if(cnt == M) {
			for(int i=0; i<select.length; i++) {
				System.out.print(select[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				select[cnt] = arr[i];
				permutation(i, cnt+1);
				visit[i] = false;
			}
		}
	}
}
/*
package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _BaekJoon15649 {
	static int N, M, arr[], select[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		select = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		permutation(0,0);
	}
	private static void permutation(int index, int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(select[i]+" ");
			}System.out.println();
		}
		for(int i=0; i<N; i++) {
			select[cnt] = arr[index];
			permutation(index+1, cnt+1);
			permutation(index+1, cnt);
		}
		
		
	}
}


*/