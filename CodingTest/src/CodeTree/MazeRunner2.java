package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MazeRunner2 { // 메이즈 러너
	static int N, M, K, exitX, exitY, move;
	static int[][] map, temp, dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y]--;
		}
		st = new StringTokenizer(br.readLine());
		exitX = Integer.parseInt(st.nextToken()) - 1;
		exitY = Integer.parseInt(st.nextToken()) - 1;
		map[exitX][exitY] = 10;

		for (int k = 0; k < K; k++) {
			moveAll();
			if(check())
				break;
			rotate();
		}
		getAnswer();
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < 0)
					return false;
			}
		}
		return true;
	}

	private static void rotate() {
		// 각 위치에서 가장 작은 정사각형 구하기
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					if (o1[1] == o2[1]) {
						return o1[2] - o2[2];
					}
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] > 0)
					continue;
				// 정사각형 찾기
				int r = Math.max(Math.abs(x - exitX), Math.abs(y - exitY)) + 1;
				int sX = Math.max(x, exitX) - r + 1;
				int sY = Math.max(y, exitY) - r + 1;
				if (sX < 0)
					sX = 0;
				if (sY < 0)
					sY = 0;
				q.offer(new int[] { r, sX, sY });
			}
		}
		// 가장 작은 사각형
		int[] rectangle = q.poll();
		int r = rectangle[0];
		int sX = rectangle[1];
		int sY = rectangle[2];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {
				int value = map[sX + i][sY + j];
				if (map[sX + i][sY + j] > 0 && map[sX + i][sY + j] < 10) {
					value--;
				}
				temp[sX + j][sY + r - i - 1] = value;

				if (map[sX + i][sY + j] == 10) {
					exitX = sX + j;
					exitY = sY + r - i - 1;
				}
			}
		}

		copyMap(temp, map);
	}

	private static void moveAll() {
		copyMap(map, temp);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < 0) {
					move(i, j);
				}
			}
		}
		copyMap(temp, map);
	}

	static void copyMap(int[][] origin, int[][] target) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				target[i][j] = origin[i][j];
			}
		}
	}

	private static void move(int x, int y) {
		int originDist = Math.abs(x - exitX) + Math.abs(y - exitY);
		for (int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || (map[nx][ny] > 0 && map[nx][ny] < 10))
				continue;
			int dist = Math.abs(nx - exitX) + Math.abs(ny - exitY);
			if (originDist > dist) {
				// 움직이기
				if (map[nx][ny] != 10) {
					temp[nx][ny] += map[x][y];
				}
				move -= map[x][y];
				temp[x][y] -= map[x][y];
				return;
			}
		}
	}

	private static void getAnswer() {
		System.out.println(move);
		System.out.println((exitX + 1) + " " + (exitY + 1));
	}
}