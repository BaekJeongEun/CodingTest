package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1389 { // 케빈 베이컨의 6단계 법칙 (S1)
	static int N, M, min = Integer.MAX_VALUE, minIdx = -1;
	static ArrayList<Integer> list[];
	static int[] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int minCnt = Integer.MAX_VALUE, minIdx = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = bfs(i);
			if (minCnt > cnt) {
				minCnt = cnt;
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}

	private static int bfs(int start) {
		Arrays.fill(dist, -1);
		int cnt = 0;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(start);
		dist[start] = 0;

		while (!Q.isEmpty()) {
			int x = Q.poll();
			for (int y : list[x]) {
				if (dist[y] != -1)
					continue;
				dist[y] = dist[x] + 1;
				cnt += dist[y];
				Q.add(y);
			}
		}
		return cnt;
	}

	private static class Point {
		int idx, cost;

		public Point(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
