package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon15650 { // N과 M(2)
	static int N, M, arr[], select[];
	static boolean visit[];
	static ArrayList<String> list;
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
		list = new ArrayList<>();
		comb(0,0);
	}
	private static void comb(int index, int cnt) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<select.length; i++) {
				sb.append(select[i]+" ");
			}
			
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=index; i<arr.length; i++) {
			select[cnt] = arr[i];
			comb(i+1, cnt+1);
		}
	}
}