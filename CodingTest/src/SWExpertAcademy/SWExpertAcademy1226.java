package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1226 { // 미로 1
	static int arr[][];
	static int exist=0;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			arr = new int[16][16];
			visited = new boolean[16][16];
			exist=0;
			int x=1, y=1;
			for (int i = 0; i < 16; i++) {
				String str[] = br.readLine().split("");
				for(int j=0; j<16; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
					if(arr[i][j]==2) {
						x=i; y=j;
					}
				}
			}
			dfs(x, y);
			System.out.println("#"+tc+" "+exist);
		}
	}
	public static void dfs(int x, int y) {
		if(arr[x][y]==3) {
			exist = 1;
			return;
		}
		for(int i=0; i<4; i++) {
			if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<16 &&y+dy[i]<16 && arr[x+dx[i]][y+dy[i]]!=1 && !visited[x+dx[i]][y+dy[i]]) {
				visited[x+dx[i]][y+dy[i]] = true;
				dfs(x+dx[i], y+dy[i]);
			}
		}
	}
}
