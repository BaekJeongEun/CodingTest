package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon16928 { // 뱀과 사다리 게임(G5)
	private static int N, M;
	private static int[] map, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[101]; 

		for (int i = 1; i <= 100; i++)
			map[i] = i;
		for (int i = 1; i <= 100; i++)
			visited[i] = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		bfs(1);
		System.out.println(visited[100]);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= 6; i++) {
				int moveTo = now + i;
				if (moveTo > 100)
					continue;
				moveTo = map[moveTo];

				if (visited[moveTo] == -1) {
					visited[moveTo] = visited[now] + 1;
					queue.offer(moveTo);
				}
			}

		}
	}

}
