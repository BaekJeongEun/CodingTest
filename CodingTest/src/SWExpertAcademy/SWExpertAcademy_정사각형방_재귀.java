package SWExpertAcademy;

import java.util.Scanner;

public class SWExpertAcademy_정사각형방_재귀 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, ansCnt, ansRoom;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			map = new int[N][N];

			int max_cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			ansCnt = 0; // 이동한 최대 방 갯수
			ansRoom = 0; // 최대 이동시 출발한 방번호
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = dfs(i,j); // 현재 좌표와 방문한 방의 갯수
					
					if(ansCnt < tmp) {
						ansCnt = tmp;
						ansRoom = map[i][j];
					}else if(ansCnt == tmp) {
						ansRoom = Math.min(ansRoom, map[i][j]);
					}
				}
			}

		}
	}
	static int dfs(int nowi, int nowj) { // 나는 현재 nowi, nowj에 서있음
		for(int d=0; d<4; d++) {	// 옆에 
			int nexti = nowi + dx[d];
			int nextj = nowj + dy[d];
			
			if (nexti >= 0 && nextj >= 0 && nexti < N && nextj < N
					&& map[nowi][nowj] + 1 == map[nexti][nextj]) {
				return dfs(nexti, nextj)+1;
			}
		}
		return 1;
	}
}
