package SWExpertAcademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWExpertAcademy_정사각형방_BFS {
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
					int tmp = bfs(i,j); // 현재 좌표와 방문한 방의 갯수
					
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
	static int bfs(int starti, int startj) { // 나는 현재 nowi, nowj에 서있음
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(starti, startj));
		
		int tmp=0;
		while(!queue.isEmpty()) {
			Point now = queue.poll(); // 실제 방문해서 현재 now 좌표에 서있음.
			tmp++; // 방문한 방의 갯수
			for(int d=0; d<4; d++) {	// 옆에 
				int nexti = now.i + dx[d];
				int nextj = now.j + dy[d];
				
				if (nexti >= 0 && nextj >= 0 && nexti < N && nextj < N
						&& map[now.i][now.j] + 1 == map[nexti][nextj]) {
					queue.add(new Point(nexti, nextj)); // 하나 더 큰 옆방도 방문 스케줄 추가!
				}
			}
		}
		return tmp;
	}
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
}
