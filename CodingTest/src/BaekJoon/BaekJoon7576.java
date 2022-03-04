package BaekJoon;

import java.util.*;
import java.io.*;

public class BaekJoon7576 {
	static int N, M;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static String arr[][];
	static Queue<Point> queue = new LinkedList<>();
	static int cnt = 0, days = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new String[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				String new_one = st.nextToken();
				arr[i][j] = new_one;
				if(new_one.equals("1")) {
					queue.add(new Point(i,j));	// 익은 토마도 큐에 넣기
				}else if(new_one.equals("0")) // 익혀야 하는 토마토 개수
					cnt++;
			}			
		}
		bfs();
		System.out.println((cnt==0)? days:-1);
	}
	
	static void bfs() {
		while(cnt>0 && !queue.isEmpty()) {
			// 하루에 익힐 수 있는 토마토 모두 큐에 넣기!
			for(int s = queue.size(); s>0; s--) {
				Point current = queue.poll();
				
				int current_x = current.x;
				int current_y = current.y;
				
				for(int i=0; i<4; i++) {
					int new_x = current_x+dx[i];
					int new_y = current_y+dy[i];
					
					if(new_x>=0 && new_x<N && new_y>=0 && new_y<M && arr[new_x][new_y].equals("0")) {
						queue.add(new Point(new_x, new_y));
						arr[new_x][new_y] = "1";
						cnt--;	// 익힌 토마토는 총 개수에서 빼주기
					}
				}
			}
			days++; // 하루에 익힐 수 있는 토마토 모두 익혔어!
			
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
