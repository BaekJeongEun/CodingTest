package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16926 {
	static int arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dir[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int TC = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		String str[] = null;
		for (int i = 0; i < h; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int tc = 0; tc < TC; tc++) {

			for (int i = 0; i < h / 2 + 1; i++) {
				int temp = arr[i][i];

				if ((h % 2 != 0 && i == h / 2)) {
					move(i, w - i - 1, w - i - 1 - i, dir[0]); // 우측 상단 꼭지점, 반복 횟수
					arr[i][w - i - 1] = temp;
				}
				else if(w>h&& i==h/2 && w%2!=0){
					move(i + 1, i, h - i - 1 - i - 1, dir[3]);
					arr[i + 1][i] = temp;
				}
				else {
					move(i, w - i - 1, w - i - 1 - i, dir[0]); // 우측 상단 꼭지점, 반복 횟수
					move(h - i - 1, w - i - 1, h - i - 1 - i, dir[1]); // 우측 하단 꼭지점
					move(h - i - 1, i, w - i - 1 - i, dir[2]); // 좌측 하단 꼭지점
					move(i + 1, i, h - i - 1 - i - 1, dir[3]); // 좌측 상단 꼭지점

					arr[i + 1][i] = temp;
				}
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void move(int i, int j, int cnt, int[] dir) {
		int x = i, y = j;
		int next, current = arr[x][y];
		for (int k = 0; k < cnt; k++) {
			next = arr[x + dir[0]][y + dir[1]];
			x += dir[0];
			y += dir[1];
			arr[x][y] = current;
			current = next;
		}
	}

}
