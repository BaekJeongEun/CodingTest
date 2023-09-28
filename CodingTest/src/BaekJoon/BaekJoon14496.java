package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14496 { // 그대, 그머가 되어(S2)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start][end] = 1;
			arr[end][start] = 1;
		}

		int[] dist = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[a] = 0;
		visit[a] = true;

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(a, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int now = node.start;
			int cost = node.cost;

			if (now == b) {
				break;
			}

			for (int next = 1; next <= N; next++) {
				if (arr[now][next] == 1 && !visit[next]) {
					dist[next] = cost + 1;
					visit[next] = true;
					queue.add(new Node(next, cost + 1));
				}
			}
		}
		System.out.println(dist[b] == Integer.MAX_VALUE ? -1 : dist[b]);
	}

	static class Node implements Comparable<Node> {
		int start;
		int cost;

		public Node(int start, int cost) {
			this.start = start;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
	}
}
