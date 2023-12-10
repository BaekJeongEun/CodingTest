package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon19237 { // 어른 상어 (G2)
	static int N, M, K;
	static int[][][] map;
	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Shark sharks[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 격자 크기
		M = Integer.parseInt(st.nextToken()); // 상어 수
		K = Integer.parseInt(st.nextToken()); // 냄새
		map = new int[N][N][M + 1]; // [x][y][상어 번호] = 냄새
		sharks = new Shark[M + 1]; // 상어 리스트
		for (int i = 1; i <= M; i++) {
			sharks[i] = new Shark();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					continue;
				map[i][j][num] = K; // 번호 , 냄새
				sharks[num].x = i;
				sharks[num].y = j;
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			sharks[i].d = (Integer.parseInt(st.nextToken()) - 1); // 초기 방향
		}
		for (int s = 1; s <= M; s++) {
			int[][] dir = new int[4][4];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				int[] temp = new int[4];
				for (int j = 0; j < 4; j++) {
					temp[j] = Integer.parseInt(st.nextToken()) - 1;
				}
				dir[i] = temp;
			}
			sharks[s].dir = dir;
		}
		int answer = 0;
		while (answer <= 1000) {
			int sum = 0;
			for (int s = 1; s <= M; s++) {
				if (sharks[s] != null)
					sum++;
			}
			if (sum == 1) {
				break;
			}
			// 냄새 줄어들고, 0이 된 곳 없애기
			answer++;
			decreaseSmell();
			// 상어 이동, 냄새 뿌리기
			moveShark();

		}
		System.out.println(answer > 1000 ? -1 : answer);
	}

	private static void decreaseSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int s = 1; s <= M; s++) {
					map[i][j][s]--;
				}
			}
		}
	}

	private static void moveShark() {
		int[][] sharkNum = new int[N][N];
		A: for (int s = 1; s <= M; s++) {
			if (sharks[s] == null)
				continue;
			int x = sharks[s].x;
			int y = sharks[s].y;
			int d = sharks[s].d;
			int[] dir = sharks[s].dir[d];
			// 냄새 뿌리기
			map[x][y][s] = K;
			int myDir = -1;
			for (int i = 0; i < 4; i++) {
				boolean possible = true;
				int nx = x + direction[dir[i]][0];
				int ny = y + direction[dir[i]][1];
				// 작은 번호 상어만 남기기
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				for (int m = 1; m <= M; m++) {
					if (map[nx][ny][m] > 0) {
						if (myDir == -1 && m == s) {
							myDir = i;
						}
						possible = false;
					}
				}
				if (possible) { // 아무 냄새 없는 칸
					// 누군가 있으면 쫓겨남
					if (sharkNum[nx][ny] > 0) {
						sharks[s] = null;
						continue A;
					} else {
						sharkNum[nx][ny] = s;
						sharks[s].x = nx;
						sharks[s].y = ny;
						sharks[s].d = dir[i];
						continue A;
					}
				}
			}
			// 갈 곳 없는 친구라면..
			int nx = x + direction[dir[myDir]][0];
			int ny = y + direction[dir[myDir]][1];
			if (sharkNum[nx][ny] == 0) {
				sharkNum[nx][ny] = s;
				sharks[s].x = nx;
				sharks[s].y = ny;
				sharks[s].d = dir[myDir];
				continue A;
			} else {
				sharks[s] = null;
				continue A;
			}
		}
	}

	static class Shark {
		int x, y, d;
		int[][] dir;

		public Shark(int d) {
			super();
			this.d = d;
		}

		public Shark() {
		}
	}
}
