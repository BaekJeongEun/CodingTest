package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14502 {
	static int N, M;
	static int[][] arr, copyArr, dir = {{1,0}, {-1, 0}, {0,1}, {0, -1}};
	static ArrayList<Point> list = new ArrayList<>();
	static ArrayList<Point> virus = new ArrayList<>();
	static boolean visit[];
	static Queue<Point> queue = new LinkedList<>();
	static int answer;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j]==0)
        			list.add(new Point(i, j));
        		else if(arr[i][j] == 2) {
        			virus.add(new Point(i, j));
        			
        		}
        	}
        }
        
        // 3개 조합 만들기
        visit = new boolean[list.size()];
        copyArr = arr;
        comb(0, 0);
        System.out.println(answer);
	}
	
	private static void comb(int idx, int cnt) {
		if(cnt == 3) {
			// bfs
			bfs(arr);
			//System.out.println("bfs 탐색");
			return;
		}
		for(int i=idx; i<list.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[list.get(i).x][list.get(i).y] = 1;
				comb(i+1, cnt+1);
				arr[list.get(i).x][list.get(i).y] = 0;
				visit[i] = false;
			}
		}
	}

	private static void bfs(int[][] copyArr) {
		int total_safe = 0;
		copyArr = new int[N][M];

        for (int i = 0; i < N; i++) {
        	copyArr[i] = arr[i].clone();
        }

		
		
		for(Point p : virus) {
			//System.out.println("virus");
			queue.add(new Point(p.x, p.y));
		}
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dir[i][0];
				int nextY = nowY + dir[i][1];
				
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<M && copyArr[nextX][nextY]==0) {
					// 바이러스 전염시키기
					copyArr[nextX][nextY] = 2;
					queue.add(new Point(nextX, nextY));
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//System.out.print(copyArr[i][j]);
				if(copyArr[i][j] == 0) {
					total_safe++;
				}
			}
		}
		//System.out.println("total "+total_safe);
		
		answer = Math.max(answer, total_safe);
	}

	public static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
