package SWExpertAcademy;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWExpertAcademy1767 {
	static int N;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int arr[][];
	static int maxCore, minLength;
	static ArrayList<Point> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			int sum = 0;

			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				// arr[i] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]);

					if (i != 0 && j != 0 && i != N - 1 && j != N - 1 && arr[i][j] == 1 && check(i, j)) {
						list.add(new Point(i, j));
					}
				}
			}
			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;

			dfs(0, 0, 0);
			System.out.println("#" + (tc + 1) + " " + minLength);
		}
	}

	static void dfs(int idx, int coreCnt, int len) {

		if (idx == list.size()) {
			if (maxCore < coreCnt) {
				maxCore = coreCnt;
				minLength = len;
			} else if (maxCore == coreCnt) {
				minLength = (minLength > len) ? len : minLength;
			}
			return;
		}

		int x = list.get(idx).x;
		int y = list.get(idx).y;

		for (int d = 0; d < 4; d++) {
			int count = 0;
			int nowX = x;
			int nowY = y;
			int nextX = x;
			int nextY = y;

			while (true) {
				nowX += dx[d];
				nowY += dy[d];

				// 벽을 만나면
				if (nowX < 0 || nowX >= N || nowY < 0 || nowY >= N)
					break;
				// 코어를 만나면
				if (arr[nowX][nowY] == 1) {
					count = 0;
					break;
				}
				count++;
			}
			// 지금 방향 그대로 1로 채우기~!
			for (int i = 0; i < count; i++) {
				nextX += dx[d];
				nextY += dy[d];

				arr[nextX][nextY] = 1;
			}
			// 전선과 연결이 불가능
			if (count == 0)
				dfs(idx + 1, coreCnt, len);
			// 전선과 연결이 가능
			else {
				// 다음 코어로 이동(연결된 코어개수 증가 , 전선길이 증가)
				dfs(idx + 1, coreCnt + 1, len + count);

				nextX = x;
				nextY = y;

				// dfs가 끝나면 전선을 다시 0으로 바꿔준다.
				for (int i = 0; i < count; i++) {
					nextX += dx[d];
					nextY += dy[d];

					arr[nextX][nextY] = 0;
				}

			}
		}
	}

	static boolean check(int x, int y) {
		int cnt = 0;
		// �����¿� �շ� ������ �����ؾ� �ϴ� �ھ� true ��ȯ!
		for (int i = 0; i < 4; i++) {
			if (arr[x + dx[i]][y + dy[i]] == 1)
				cnt++;
		}
		return (cnt == 4) ? false : true;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
