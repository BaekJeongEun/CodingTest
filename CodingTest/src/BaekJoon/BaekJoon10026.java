package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon10026 { // 
	
	static int N;
	static boolean visit[][];
	static char arr[][];
	static int dir[][]= {{1,0}, {-1,0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new boolean[N][N];
		char[] charArr = new char[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			charArr = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j] = charArr[j];
			}
		}
		int abled=0;
		// 일반인
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					bfs(i, j, 0, arr[i][j]);
					abled++;
				}
			}
		}

		visit = new boolean[N][N];
		int disabled=0;
		// 적록색맹인
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					bfs(i, j, 1, arr[i][j]);
					disabled++;
				}
			}
		}
		System.out.println(abled + " "+disabled);

	}
	private static void bfs(int i, int j, int status, char color) {		
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(i, j));
		int x = i, y=j;
		while(!queue.isEmpty()) {			
			Point now = queue.poll();
			
			int nextX = now.x;
			int nextY = now.y;
			
			for(int d = 0; d<4; d++) {
				nextX = now.x + dir[d][0];
				nextY = now.y + dir[d][1];
				if(status==0 && nextX>=0 && nextY>=0 && nextX<N && nextY<N && !visit[nextX][nextY] &&arr[nextX][nextY]==color) { // 일반인이고 같은 색이면 방문 체크
					visit[nextX][nextY] = true;
					queue.add(new Point(nextX, nextY));
				}
				else if(status==1 && nextX>=0 && nextY>=0 && nextX<N && nextY< N && !visit[nextX][nextY] ) {
					if(arr[nextX][nextY]==color || ((color=='R'||color=='G') && arr[nextX][nextY]!='B')) {
						visit[nextX][nextY] = true;
						queue.add(new Point(nextX, nextY));
					}
				}
			}
		}
		
	}
	
	private static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
