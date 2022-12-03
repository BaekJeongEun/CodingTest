package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon20056 { // 마법사 상어와 파이어볼 (G4)
	static int N, M, K;
	// 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static ArrayList<Point>[][] arr;
	static ArrayList<Point> q = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Point now = new Point(r, c, m, s, d);
			q.add(now);
			arr[r][c].add(now);
		}
		for (int i = 0; i < K; i++) {
			fireball();
		}
		int sum = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(arr[i][j]!=null){
					for(int k=0; k<arr[i][j].size(); k++) {
						sum += arr[i][j].get(k).m;
					}
				}
			}
		}
		System.out.println(sum);
	}

	private static void fireball() {
		// 파이어볼 Q 움직이기, map에 저장
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		for (int i=0; i<q.size(); i++) {
			Point now = q.get(i);
			// 현재 파이어볼 움직이기
			now.x = (now.x + dir[now.d][0]*(now.s))%N;
			now.y = (now.y + dir[now.d][1]*(now.s))%N;
			if(now.x >= N) now.x -= N;
			if(now.x < 0) now.x += N;
			if(now.y >= N) now.y -= N;
			if(now.y < 0) now.y += N;
			arr[now.x][now.y].add(now);
		}

		// map에 있는 파이어볼 4등분
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ArrayList<Point> now = arr[i][j];
				if(now != null && now.size() > 1) {
					int sumM=0, sumS=0, sumCnt=0, sumD=0;
					boolean isEven = true;
					boolean isOdd = true;
					for(Point cur : arr[i][j]) {
						sumM += cur.m;
						sumS += cur.s;
						sumCnt++;
						if(cur.d %2 ==0) {
							isOdd = false;
						}else {
							isEven = false;
						}
					}
					
					int M = sumM/5;
					int S = sumS/sumCnt;
					
					arr[i][j] = new ArrayList<>();
					if(M <= 0) {
						return;
					}
					
					if(isEven || isOdd) {
						for(int d=0; d<4; d++) {
							arr[i][j].add(new Point(i,j,M,S,i*2));
						}
					}else {
						for(int d=0; d<4; d++) {
							arr[i][j].add(new Point(i,j,M,S,i*2+1));
						}
					}
				}
			}
		}
		
		q = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
 			for(int j=1; j<N+1; j++) {
 				if(arr[i][j].size() > 0){
 					for(Point cur : arr[i][j]) {
 						q.add(cur);
 					}
 				}
 			}
 		}
	}

	private static class Point {
		int x, y, m, s, d;
		int cnt;

		public Point(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", m=" + m + ", s=" + s + ", d=" + d + ", cnt=" + cnt + "]";
		}
		
	}
}
