package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon18352 { // 특정 거리의 도시 찾기 (S2)
	static int N,M,K,X;
	static ArrayList<Integer>[] arr;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		count = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
		}
		bfs();
	}
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(X);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<arr[now].size(); i++) {
				if(count[arr[now].get(i)] == 0) {
					q.offer(arr[now].get(i));
					count[arr[now].get(i)] = count[now]+1;
				}
			}
		}
		boolean exit = false;
		for(int i=1; i<count.length; i++) {
			if(count[i] == K && i!=X) {
				System.out.println(i);
				exit = true;
			}
		}
		if(!exit) System.out.println(-1);
	}

}
