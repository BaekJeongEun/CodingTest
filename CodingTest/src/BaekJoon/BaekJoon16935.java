package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon16935 { // 배열 돌리기 3 (S1)
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int move = Integer.parseInt(st.nextToken());

			switch (move) {
			case 1:
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate(5);
				break;
			case 6:
				rotate(6);
				break;

			default:
				break;
			}

			N = arr.length;
			M = arr[0].length;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void rotate(int move) {
		int temp[][] = new int[N][M];
		if (move == 5) {
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i][j] = arr[i + N / 2][j];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i][j] = arr[i][j - M / 2];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i][j] = arr[i][j + M / 2];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i][j] = arr[i - N / 2][j];
				}
			}
		} else {
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i][j] = arr[i][j + M / 2];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i][j] = arr[i + N / 2][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					temp[i][j] = arr[i - N / 2][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					temp[i][j] = arr[i][j - M / 2];
				}
			}
		}

		arr = temp;
	}

	static private void rotate1() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[N - i - 1][j];
			}
		}
		arr = temp;
	}

	static private void rotate2() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][M - j - 1];
			}
		}
		arr = temp;
	}

	static private void rotate3() {
		int temp[][] = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				temp[j][N - i - 1] = arr[i][j];
		arr = temp;
	}

	static private void rotate4() {
		int temp[][] = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				temp[M - j - 1][i] = arr[i][j];
		arr = temp;
	}

}