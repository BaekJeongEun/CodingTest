package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy상호의배틀필드 {

	static int T, H, W, x, y;
	static char[][] arr;
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			x = 0;
			y = 0;
			arr = new char[H][W];
			String str;
			for (int i = 0; i < H; i++) {
				str = br.readLine();

				for (int j = 0; j < W; j++) {
					arr[i][j] = str.charAt(j);
					if ("v><^".contains(arr[i][j] + "")) {
						x = i;
						y = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			str = br.readLine();

			char direction = arr[x][y]; // 전차가 바라보는 방향
			if (direction == '<')
				direction = 'L';
			if (direction == '>')
				direction = 'R';
			if (direction == '^')
				direction = 'U';
			if (direction == 'v')
				direction = 'D';

			for (int i = 0; i < N; i++) {
				char next = str.charAt(i);

				if (next == 'S') {

					move(x, y, direction, false); // 0이면 폭격
				} else {
					direction = next;
					move(x, y, next, true); // 1이면 그냥 이동
				}

			}
			System.out.print("#"+tc+" ");
			for (int a = 0; a < H; a++) {
				for (int b = 0; b < W; b++) {
					System.out.print(arr[a][b]);
				}
				System.out.println();
			}
		}
	}

	private static void move(int currx, int curry, char direction, boolean move) {
		boolean exit = false;
		int nextX = currx;
		int nextY = curry;

		int d = 0;
		if (direction == 'U') {
			d = 0;
			if (move)
				arr[currx][curry] = '^';
		} else if (direction == 'D') {
			d = 1;
			if (move)
				arr[currx][curry] = 'v';
		} else if (direction == 'L') {
			d = 2;
			if (move)
				arr[currx][curry] = '<';
		} else if (direction == 'R') {
			d = 3;
			if (move)
				arr[currx][curry] = '>';
		}

		nextX += dir[d][0];
		nextY += dir[d][1];

		if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) { // 범위 벗어나면 OUT!
			return;
		} else if (move && arr[nextX][nextY] == '.') { // 범위 벗어나지도 않았고 움직일 수 있다면
			
			arr[nextX][nextY] = arr[x][y];
			arr[x][y] = '.';
			x = nextX;
			y = nextY;
		} else if (!move) {
			while (!exit) {
				if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) { // 범위 벗어나면 OUT!
					exit = true;
					break;
				} else if (arr[nextX][nextY] == '*') { // 범위 벗어나지 않았고, 폭격기인데다가 벽을 만났다?!
					arr[nextX][nextY] = '.';
					break;
				} else if (arr[nextX][nextY] == '#') {
					break;
				}

				nextX += dir[d][0];
				nextY += dir[d][1];
			}
		}

	}
}
