package SWExpertAcademy;

import java.util.Scanner;

public class SWExpertAcademy_정사각형방 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			int max_cnt = 0;
			int room_num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 1;
					int nowx = i;
					int nowy = j;
					while (true) {
						boolean escape = false;
						for (int k = 0; k < 4; k++) { // 네 방향 탐색
							int new_x = nowx + dx[k];
							int new_y = nowy + dy[k];

							if (new_x >= 0 && new_y >= 0 && new_x < N && new_y < N
									&& map[nowx][nowy] + 1 == map[new_x][new_y]) {
								cnt++;
								nowx = new_x;
								nowy = new_y;
								escape = true;
								break;
							}
						}
						if (!escape)
							break;
					}
					if (max_cnt < cnt) {
						max_cnt = cnt;
						room_num = map[i][j];
					} else if (max_cnt == cnt) {
						room_num = Math.min(room_num, map[i][j]);
					}
				}
			}
			System.out.println("#" + tc + " "+ room_num+" "+ max_cnt);
		}
	}
}
