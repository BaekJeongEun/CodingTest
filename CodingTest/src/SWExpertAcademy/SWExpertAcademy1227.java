package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWExpertAcademy1227 { // 미로2 (D4)
	static int[][] arr, dir= {{0,-1},{-1,0},{0,1},{1,0}};
	static int sX, sY, eX, eY;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			arr = new int[100][100];
			for(int i=0; i<100; i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j=0; j<100; j++) {
					arr[i][j] = temp[j]-48;
					if(arr[i][j] == 2) {
						sX = i; sY = j;
					}else if(arr[i][j] == 3) {
						eX = i; eY = j;
					}
				}
			}
			visit = new boolean[100][100];
			sb.append("#"+tc+" "+bfs()+"\n");
		}		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque();
		q.offer(new int[] {sX, sY});
		visit[sX][sY] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			if(x == eX && y == eY) {
				return 1;
			}
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0 || ny<0 || nx>=100 || ny>=100 || visit[nx][ny] || arr[nx][ny]==1) continue;
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}
		return 0;
	}

}
