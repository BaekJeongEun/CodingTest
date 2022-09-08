package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon17144 { // 미세먼지 안녕! (G4)
	static int R, C, T;
	static int[][] arr;
	static Queue<Point> dust;
	static int[][] dirUp = {{ -1,0 } , { 0,1 }, { 1,0 }, { 0,-1 } };// 위, 오른 아래, 왼
	static int[][] dirDown = { { 1,0 } , { 0,1 }, { -1,0 }, { 0,-1 }};// 아래, 오른, 위, 왼
	static int upX = -1, upY = 0, downX = -1, downY = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		dust = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0) {
					dust.offer(new Point(i, j));
				} else if (arr[i][j] == -1 && upX == -1) {
					upX = i;
					downX = i + 1;
				}
			}
		}
		for (int i = 1; i <= T; i++) {
			// 미세먼지 확산
			diffusion();
			// 공기청정기 작동 위
			airCleaner('U');
			// 아래
			airCleaner('D');
		}
		int total = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != -1) {
					total += arr[i][j];
				}
			}
		}
		System.out.println(total);
	}

	private static void diffusion() { // 미세먼지 확산
		int size = dust.size();
		int[][] temp = new int[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] > 0) {
					int dustAmount = arr[i][j]; // 타겟 위치의 미세먼지양
					int dustSeperate = dustAmount / 5; // 뿌려야 할 미세먼지양
					int spreadCnt = 0; // 몇 번 뿌릴 수 있는지
					for (int d = 0; d < 4; d++) {
						int nextX = i + dirUp[d][0];
						int nextY = j + dirUp[d][1];
						if (isArea(nextX, nextY,0, R) || arr[nextX][nextY] == -1)
							continue; // 범위 벗어나거나 공기정청기 위치일 경우
						temp[nextX][nextY] += dustSeperate;
						temp[i][j] -= dustSeperate;
						dust.offer(new Point(nextX, nextY));
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] += temp[i][j];
			}
		}
	}

	private static void airCleaner(char direction) {
		int d = 0;
		int nextX = upX;
		int nextY = upY;
		
		
		if (direction == 'D') {
			int x = downX;
			int y = downY;
			while(true) {
				nextX =x+dirDown[d][0];
				nextY =y+dirDown[d][1];
				
				if (isArea(nextX, nextY, downX, R)) {
					d++;
					continue;
				}
				if(nextX == downX && nextY == downY) {
					arr[x][y] = 0;
					arr[nextX][nextY] = -1;
					break;
				}
				arr[x][y]=arr[nextX][nextY];
				x = nextX;
				y = nextY;
			}
		} else {
			int x = upX;
			int y = upY;
			
			while(true) {
				nextX =x+dirUp[d][0];
				nextY =y+dirUp[d][1];
				
				if (isArea(nextX, nextY, 0, upX+1)) {
					d++;
					continue;
				}
				if(nextX == upX && nextY == upY) {
					arr[x][y] = 0;
					arr[nextX][nextY] = -1;
					break;
				}
				arr[x][y]=arr[nextX][nextY];
				x = nextX;
				y = nextY;
			}
		}
	}

	private static boolean isArea(int x, int y, int r1, int r) {
		return (x < r1 || y < 0 || x >= r || y >= C);
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
