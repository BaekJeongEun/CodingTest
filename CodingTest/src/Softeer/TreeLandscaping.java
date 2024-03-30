package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeLandscaping { // 나무 조경 (L3)
	static int N, M, max = Integer.MIN_VALUE;
	static int[][] height, dir = {{0,1},{1,0}};
	static int[][][] arr, pick;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		M = ((N-1)*N)*2;
		height = new int[N][N];
		visit = new boolean[N][N];
		arr = new int[M][2][2];
		pick = new int[4][2][2];
		int answer = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				answer += height[i][j];
			}
		}
		if(N<=2) {
			System.out.println(answer);
			System.exit(0);
		}
		int idx = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int d=0; d<2; d++) {
					// i == N-1 일 때는 d = 0만 고려
					if(i == N-1 && d==1) continue;
					// j == N-1 일 때는 d = 1만 고려
					if(j == N-1 && d==0) continue;

					int nx = i + dir[d][0];
					int ny = j + dir[d][1];
					arr[idx++] = new int[][] {{i, j},{nx, ny}};
				}
			}
		}
		dfs(0, 0);
		System.out.println(max);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == 4) {
			int answer = 0;
			for(int i=0; i<4; i++) {
				answer += height[pick[i][0][0]][pick[i][0][1]];
				answer += height[pick[i][1][0]][pick[i][1][1]];
			}
			max = Math.max(max, answer);
			return;
		}
		for(int i=idx; i<M; i++) {
			pick[cnt] = arr[i];
			if(visit[arr[i][0][0]][arr[i][0][1]] || visit[arr[i][1][0]][arr[i][1][1]]) continue;
			visit[arr[i][0][0]][arr[i][0][1]] = true;
			visit[arr[i][1][0]][arr[i][1][1]] = true;
			dfs(i+1, cnt+1);
			visit[arr[i][0][0]][arr[i][0][1]] = false;
			visit[arr[i][1][0]][arr[i][1][1]] = false;
		}
	}

}
