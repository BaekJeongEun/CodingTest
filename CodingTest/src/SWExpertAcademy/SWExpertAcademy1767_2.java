package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWExpertAcademy1767_2 { // 프로세서 연결하기
	static int N, maxCoreCnt, minCoreLength;
	static int[][] arr, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<Point> core;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			core = new ArrayList<>();
			maxCoreCnt = Integer.MIN_VALUE;
			minCoreLength = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1 && i!=0 && j!=0 && i!=N-1 && j!=N-1) {
						core.add(new Point(i, j));
					}
				}
			}
			dfs(0, 0, 0); // 코어 인덱스, 코어 개수, 전선 길이
			sb.append("#"+tc+" "+minCoreLength+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int idx, int coreCnt, int coreLength) {
		if(idx == core.size()) {
			if(maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				minCoreLength = coreLength;
			}else if(maxCoreCnt == coreCnt) {
				minCoreLength = Math.min(minCoreLength, coreLength);
			}
			return;
		}
		
		int x = core.get(idx).x;
		int y = core.get(idx).y;
		int nx = x, ny = y;
		for(int d=0; d<4; d++) {
			// 전선과 연결되는 코어 찾기
			// 현재 방향으로만 갔을 때 전선 길이 구하기, 중간에 코어 만나거나 벽 만나면 끝
			nx = x;
			ny = y;
			int length = 0;
			while(true) {
				nx += dir[d][0];
				ny += dir[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N) {
					break;
				}
				if(arr[nx][ny] == 1) {
					length = 0;
					break;
				}
				length++;
			}
			// 전선과 연결되지 않는다면 cnt와 length 그대로 다음 코어 찾으러
			if(length == 0) {
				dfs(idx+1, coreCnt, coreLength);
			}
			
			// 전선과 연결된다면 cnt와 length 늘려서 다음 코어 찾으러
			else {
				nx = x;
				ny = y;
				for(int i=0; i<length; i++) {
					nx += dir[d][0];
					ny += dir[d][1];
					arr[nx][ny] = 1;
				}
				dfs(idx+1, coreCnt+1, coreLength+length);
				nx = x;
				ny = y;
				for(int i=0; i<length; i++) {
					nx += dir[d][0];
					ny += dir[d][1];
					arr[nx][ny] = 0;
				}
			}
		}
	}

	private static class Point{
		int x, y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
