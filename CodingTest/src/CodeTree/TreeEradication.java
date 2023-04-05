package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TreeEradication { // 나무 박멸 (G4)

	static int n, m, k, c, result = 0;
	static Tree[][] arr;
	static PriorityQueue<Tree> queue = new PriorityQueue<>();
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] crossDir = { { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new Tree[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int cnt = Integer.parseInt(st.nextToken());
				boolean isTree = cnt != -1;
				arr[i][j] = new Tree(i, j, isTree, cnt, 0);
			}
		}
		for (int M = 0; M < m; M++) {
			growth();
			breeding();
			decreaseYear();
			kill();
		}
		System.out.println(result);
	}

	private static void kill() {
		// k 대각선 방향으로 박멸 나무 개수 모두 구하기
		queue.clear();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j].count > 0) {
					int x = arr[i][j].x;
					int y = arr[i][j].y;
					arr[x][y].destroy = arr[x][y].count;
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						for (int K = 0; K < k; K++) {
							int nx = x + crossDir[d][0] * (K + 1);
							int ny = y + crossDir[d][1] * (K + 1);
							if (isArea(nx, ny) && arr[nx][ny].isTree && arr[nx][ny].count >= 0) {
								cnt += arr[nx][ny].count;
								if(arr[nx][ny].count == 0) break;
							} else break;
						}
					}
					arr[x][y].destroy += cnt;
					queue.offer(arr[x][y]);
				}
			}
		}
		Tree max = queue.poll();
		if (max == null)
			return;
		result += max.destroy;
		int x = max.x;
		int y = max.y;
		arr[x][y].herbicideYear = c;
		arr[x][y].count = 0;
		for (int d = 0; d < 4; d++) {
			for (int K = 0; K < k; K++) {
				int nx = x + crossDir[d][0] * (K + 1);
				int ny = y + crossDir[d][1] * (K + 1);
				if (isArea(nx, ny) && arr[nx][ny].isTree && arr[nx][ny].count >= 0) {
					arr[nx][ny].herbicideYear = c;
					if(arr[nx][ny].count == 0) break;
					arr[nx][ny].count = 0;
				} else
					break;
			}
		}
	}

	private static void breeding() {
		// 나무 / 빈 칸 개수
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = arr[i][j].count;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j].isTree && arr[i][j].count > 0) {
					int x = arr[i][j].x;
					int y = arr[i][j].y;
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = x + dir[d][0];
						int ny = y + dir[d][1];
						if (isArea(nx, ny) && arr[nx][ny].isTree && arr[nx][ny].count == 0 && arr[nx][ny].herbicideYear <= 0) { // 인접 빈 칸
							cnt++;
						}
					}
					for (int d = 0; d < 4; d++) {
						int nx = x + dir[d][0];
						int ny = y + dir[d][1];
						if (isArea(nx, ny) && arr[nx][ny].isTree && arr[nx][ny].count == 0 && arr[nx][ny].herbicideYear <= 0 && cnt > 0) { // 인접 빈 칸
							temp[nx][ny] += (arr[x][y].count / cnt);
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j].count = temp[i][j];
			}
		}
	}

	private static void growth() {
		// 나무가 있는 칸의 수만큼 + => count > 0,
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j].isTree && arr[i][j].count > 0) { // 나무 있는 칸에
					int x = arr[i][j].x;
					int y = arr[i][j].y;
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = x + dir[d][0];
						int ny = y + dir[d][1];
						if (isArea(nx, ny) && arr[nx][ny].count > 0) { // 인접 나무 개수만
							cnt++;
						}
					}
					arr[i][j].count += cnt;
				}
			}
		}
	}

	private static void decreaseYear() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j].isTree && arr[i][j].herbicideYear > 0) {
					arr[i][j].herbicideYear--;
				}
			}
		}
	}

	private static boolean isArea(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}

	public static class Tree implements Comparable<Tree> {

		boolean isTree;
		int x, y, count, destroy;
		int herbicideYear;

		public Tree(int x, int y, boolean isTree, int count, int herbicideYear) {
			this.x = x;
			this.y = y;
			this.isTree = isTree;
			this.count = count;
			this.herbicideYear = herbicideYear;
		}

		@Override
		public int compareTo(Tree o) {
			if (this.destroy == o.destroy) {
				if (this.x == o.x) {
					return this.y - o.y; // 오름차순
				}
				return this.x - o.x; // 오름차순
			}
			return o.destroy - this.destroy; // 내림차순
		}
	}
}
