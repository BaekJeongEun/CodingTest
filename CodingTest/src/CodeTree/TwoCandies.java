package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoCandies { // 2개의 사탕
	static int N, M, min = Integer.MAX_VALUE;
	static boolean[][][] visit;
	static char[][] arr;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}}; // 우 좌 하 상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	    Candy red = null, blue = null;
	    visit = new boolean[N][M][2];
		arr = new char[N][M];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 'R') {
					red = new Candy(i, j);
					arr[i][j] = '.';
				}else if(arr[i][j] == 'B'){
					blue = new Candy(i, j);
					arr[i][j] = '.';
				}
			}
		}
		dfs(red, blue, 0);
		System.out.println(min > 10 ? -1 : min);
	}
	private static void dfs(Candy red, Candy blue, int cnt) {
		if(cnt > 10) {
			return;
		}
		if(arr[blue.x][blue.y] == 'O') {
			return;
		}
		if(arr[red.x][red.y] == 'O') {
			min = Math.min(min, cnt);
			return;
		}
		visit[red.x][red.y][0] = true;
		visit[blue.x][blue.y][1] = true;
		Candy[] candies = null;
		for(int d=0; d<4; d++) {
			candies = roll(red, blue, d);
			if(visit[candies[0].x][candies[0].y][0] && visit[candies[1].x][candies[1].y][1]) continue;
			dfs(candies[0], candies[1], cnt+1);
		}
		visit[red.x][red.y][0] = false;
		visit[blue.x][blue.y][1] = false;
	}
	private static Candy[] roll(Candy red, Candy blue, int d) {
		int[] movedRed = move(red, d);
		int[] movedBlue = move(blue, d);
		int redDist = Math.abs(red.x-movedRed[0]) + Math.abs(red.y-movedRed[1]);
		int blueDist = Math.abs(blue.x-movedBlue[0]) + Math.abs(blue.y-movedBlue[1]);
		if(movedRed[0] == movedBlue[0] && movedRed[1] == movedBlue[1] && arr[movedRed[0]][movedRed[1]]!='O') {
			if(redDist < blueDist) {
				movedBlue[0] -= dir[d][0];
				movedBlue[1] -= dir[d][1];
			}else {
				movedRed[0] -= dir[d][0];
				movedRed[1] -= dir[d][1];
			}
		}
		return new Candy[] {new Candy(movedRed[0], movedRed[1]), new Candy(movedBlue[0], movedBlue[1])};
	}
	private static int[] move(Candy candy, int d) {
		int nx = candy.x;
		int ny = candy.y;
		while(arr[nx+dir[d][0]][ny+dir[d][1]] != '#') {
			nx += dir[d][0];
			ny += dir[d][1];
			if(arr[nx][ny]=='O') break;
		}
		return new int[] {nx, ny};
	}
	static class Candy {
		int x, y;
		public Candy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
