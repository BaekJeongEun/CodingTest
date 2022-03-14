package SWExpertAcademy;

import java.util.Scanner;

public class SWExpertAcademy1210 {
	static int TC;
	static int ans;
	static int[][] map;

	static int[] di = { 0, 0, -1 }; // 0:left, 1:right, 2:up
	static int[] dj = { -1, 1, 0 };

	static int nowi, nowj, nexti, nextj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TC = 10;
		for (int tc = 1; tc <= TC; tc++) {
			sc.nextInt(); // tc 번호가 굳이 입력으로 들어옴. 안쓸거지만 받아줌

			ans = -1;
			map = new int[100][100];
			nowi = nowj = nexti = nextj = -1; // 초기화

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) { // 바닥 출발점
						nowi = i;
						nowj = j;
					}
				}
			}

			while (true) {
				map[nowi][nowj] = 9;
				for (int d = 0; d < 3; d++) { // 3개 방향 중 이동 가능한 옆 칸 찾아서 현재 좌표 변경
					nexti = nowi + di[d];
					nextj = nowj + dj[d];

					if (nexti >= 0 && nexti < 100 && nextj >= 0 && nextj < 100 && map[nexti][nextj] == 1) {
						nowi = nexti;
						nowj = nextj;
						break; // 좌, 우, 상 순서로 탐색중. 좌, 우 중에 이동 가능하면 바로 이동하고 위로는 안 가야함.
					}
				}
				if(nowi == 0) { // 꼭대기 도착!
					ans = nowj; // 현재 열번호가 답!
					break; // while 종료!
				}
			}
			
//			print(map);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void print(int[][] map) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print((map[i][j]==9?"*":map[i][j])+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
