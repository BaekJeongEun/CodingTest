package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2573 { // 빙산 (G4)
	static int N,M, year;
	static int arr[][], dir[][]= {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visit;
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
			}
		}
		
		while(true) {
			// 빙산이 두 부분 이상으로 나뉘는지
			if(isSeparate()) break;
			// 빙산 양 줄이기
			if(!decreaseIce()) break;
			year++;
		}
		System.out.println(year);
	}
	private static boolean decreaseIce() {
		int[][] temp = new int[N][M];
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] > 0) {
					int cnt = 0;
					for(int d=0; d<4; d++) {
						int nx = i+dir[d][0];
						int ny = j+dir[d][1];
						if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny]<=0) {
							cnt++;
						}
					}
					temp[i][j] = cnt;
					total++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]<=0) continue;
				arr[i][j] -= temp[i][j];
			}
		}
		return true;
	}
	private static boolean isSeparate() {
		int count = 0;
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] > 0 && !visit[i][j]) {
					count++;
					Queue<int[]> q = new ArrayDeque<int[]>();
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					while(!q.isEmpty()) {
						int[] now = q.poll();
						int x = now[0];
						int y = now[1];
						for(int d=0; d<4; d++) {
							int nx = x + dir[d][0];
							int ny = y + dir[d][1];
							if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny] <= 0) continue;
							visit[nx][ny] = true;
							q.offer(new int[] {nx, ny});
						}
					}
				}
			}
		}
		if(count == 0) {
			year=0;
			return true;
		}
		return count>=2?true:false;
	}

}
