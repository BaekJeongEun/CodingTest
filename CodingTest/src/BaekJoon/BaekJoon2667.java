package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2667 { // 단지번호붙이기 (S1)
	static boolean visited[][];
	static int arr[][];
	static ArrayList<Integer> house_list;
	static int N, cnt;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		house_list = new ArrayList<>();	
		String st[]= new String[N];
		for(int i=0; i<N; i++) {
			st = br.readLine().split("");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					cnt=0;
					bfs(i,j);
					house_list.add(cnt);
				}
			}
		}
		System.out.println(house_list.size());
		Collections.sort(house_list);
		for(Integer h : house_list)
			System.out.println(h);
	}
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int p_x = p.x;
			int p_y = p.y;
			cnt++;

			arr[p_x][p_y] = 0;
			for(int i=0; i<4; i++) {
				int new_x = p_x + dx[i];
				int new_y = p_y + dy[i];
				
				if(new_x>=0 && new_y>=0 && new_x<N && new_y<N && arr[new_x][new_y]==1 && !visited[new_x][new_y]) {
					q.add(new Point(new_x, new_y));
					visited[new_x][new_y] = true;
				}
			}
		}
	}
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2667 {
	static boolean visited[][];
	static int arr[][];
	static ArrayList<Integer> house_list;
	static int N, cnt;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		house_list = new ArrayList<>();
		String st[] = new String[N];
		for (int i = 0; i < N; i++) {
			st = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					dfs(i, j);
					house_list.add(cnt);

				}
			}
		}
		System.out.println(house_list.size());
		Collections.sort(house_list);
		for (Integer h : house_list)
			System.out.println(h);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];

			if (new_x >= 0 && new_y >= 0 && new_x < N && new_y < N && arr[new_x][new_y] == 1
					&& !visited[new_x][new_y]) {
				dfs(new_x,new_y);
				cnt++;
			}
		}
	}

}
*/