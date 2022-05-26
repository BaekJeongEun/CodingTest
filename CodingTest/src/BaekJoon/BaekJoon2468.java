package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2468 {

	static int n, max=-1, cnt, m_cnt=-1;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		String str[];
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				max = (max<arr[i][j])?arr[i][j]:max;
			}
		}
		for(int ct=1; ct<=max; ct++) {
			// 1층 이하, 2층 이하, ...
			cnt=0;
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]>=ct && !visited[i][j]) { // 타겟층 이상일 때 bfs 수행
						bfs(i,j, ct);
						cnt++;
					}
				}
				m_cnt = (m_cnt<cnt)?cnt:m_cnt;
			}
		}
		System.out.println(m_cnt);
	}
	public static void bfs(int i, int j, int h) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(i,j));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point q = queue.poll();
			int n_x = q.x;
			int n_y = q.y;
			for(int k=0; k<4; k++) {
				int nx = n_x +dx[k];
				int ny = n_y +dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && arr[nx][ny]>=h) {
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
