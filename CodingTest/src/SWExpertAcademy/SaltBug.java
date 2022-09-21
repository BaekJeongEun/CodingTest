package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SaltBug {
	static int[][] arr;
	static int N, bug;
	static int dir[][] = { { 1, 0 }, { 0, 1 } }; // 하, 우

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			bug = Integer.parseInt(st.nextToken());
			int answer = 1;
			int total = 0;
			boolean exit = false;
			for (int i = 0; i < bug; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int jump = 3;
				arr[x][y] = 1;
				total++; // 몇 번째 소금쟁이인지

				int nextX = x;
				int nextY = y;
				for(int j=0; j<3 && !exit; j++) {
					nextX += dir[d-1][0] * jump;
					nextY += dir[d-1][1] * jump;
					jump--; // 점프 수 줄어들게
					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) { // 영역 내부라면
						if (arr[nextX][nextY] == 1) { // 이미 뛰었던 자리라면
							answer = total;
							exit = true;
						}
						arr[nextX][nextY]++;
					}
				}
			}
			System.out.println("#" + tc + " " + ((answer==1)?0:answer));
		}
	}

}
