package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14466 { // 소가 길을 건너간 이유 6(G4)
	static int N, K, R, answer;
	static ArrayList<int[]> arr[][];
	static ArrayList<int[]> cows;
	static int[][] map, dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1][N + 1];
		cows = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		map = new int[N + 1][N + 1];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			arr[r1][c1].add(new int[] { r2, c2 });
			arr[r2][c2].add(new int[] { r1, c1 });
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cows.add(new int[] { r, c });
			map[r][c] = 1;
		}
		for (int i = 0; i < cows.size(); i++) {
			bfs(i);
		}
		System.out.println(answer);
	}

	private static void bfs(int t) {
		int count = 0;

		boolean[][] visited = new boolean[N + 1][N + 1];
		boolean[][] cowContacted = new boolean[K][K];
		Queue<int[]> queue = new LinkedList<>();

		int[] cow = cows.get(t);
		queue.offer(cow);
		visited[cow[0]][cow[1]] = true;

		while (!queue.isEmpty()) {
			int[] node = queue.poll();

			if (map[node[0]][node[1]] == 1) {
				for (int j = t + 1; j < K; j++) {
					int[] nextCow = cows.get(j);

					if (nextCow[0] == node[0] && nextCow[1] == node[1]) {
						cowContacted[t][j] = true;
						break;
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int new_x = node[0] + dir[i][0];
				int new_y = node[0] + dir[i][1];

				if (!isInArea(new_x, new_y) || visited[new_x][new_y]) {
					continue;
				}

				if (arr[node[0]][node[1]].contains(new int[] { new_x, new_y })) {
					continue;
				}

				visited[new_x][new_y] = true;
				queue.offer(new int[] { new_x, new_y });
			}
		}

		for (int i = t + 1; i < K; i++) {
			if (!cowContacted[t][i]) {
				answer++;
			}
		}
	}

	private static boolean isInArea(int x, int y) {
		return x > 0 && y > 0 && x <= N && y <= N;
	}
}
