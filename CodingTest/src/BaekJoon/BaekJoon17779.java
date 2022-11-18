package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon17779 { // 게리맨더링 2 (G3)
	static int N, ans = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[][] arr, bound, dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		bound = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// x, y, d1, d2 구하기
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if (x + d1 + d2 < N && y + d2 <= N && y - d1 > 1 && y + d2 < N) {
							bound = new int[N + 1][N + 1];
							seperate(x, y, d1, d2);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static void seperate(int x, int y, int d1, int d2) {
		int sum = 0;
		// 구역 5번 그리기
		draw5(x, y, d1, d2);
		// 1구역
		for (int i = 1; i <= x + d1; i++) {
			for (int j = 1; j <= y + d1; j++) {
				if (bound[i][j] == 5)
					break;
				sum += arr[i][j];
			}
		}
		min = Math.min(min, sum);
		max = Math.max(max, sum);
		// 2구역
		for (int i = 1; i <= x + d1; i++) {
			for (int j = N; j > y; j--) {
				if (bound[i][j] == 5)
					break;
				sum += arr[i][j];
			}
		}
		min = Math.min(min, sum);
		max = Math.max(max, sum);
		// 3구역
		for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (bound[i][j] == 5) break;
                sum += arr[i][j];
            }
        }
		min = Math.min(min, sum);
		max = Math.max(max, sum);
		// 4구역
		 for (int i = x + d2 + 1; i < N; i++) {
	            for (int j = N - 1; j >= y - d1 + d2; j--) {
				if (bound[i][j] == 5)
					break;
				sum += arr[i][j];
			}
		}
		min = Math.min(min, sum);
		max = Math.max(max, sum);
		
		ans = max - min;
	}

	private static void draw5(int x, int y, int d1, int d2) {
		bound[x][y] = 5;
		// 좌상
		for (int i = 1; i <= d1; i++) {
			bound[x + i][y - i] = 5;
		}
		// 우상
		for (int i = 1; i <= d2; i++) {
			bound[x + i][y + i] = 5;
		}
		// 좌하
		x = x - d1;
		for (int i = 1; i <= d2; i++) {
			bound[x + i + d2][y - i - d1] = 5;
		}
		// 우하

		for (int i = 1; i <= d1; i++) {
			bound[x + i + d2][y - i + d2] = 5;
		}
	}

}