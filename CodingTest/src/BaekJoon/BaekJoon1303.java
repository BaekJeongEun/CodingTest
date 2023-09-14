package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1303 { // 전쟁-전투 (S1)
	static int N; 
	static int M; 
	static int now_x;
	static int now_y;
	static int count = 0;

	static int white_count = 0;
	static int black_count = 0;
	static char map[][];
	static boolean visit[][];

	static int dirY[] = {-1, 1, 0, 0}; 
	static int dirX[] = {0, 0, -1, 1}; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 
		M = Integer.parseInt(st.nextToken()); // 세로

		// 1. 지도 만들기
		map = new char[M][N];
		visit = new boolean[M][N];
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch; 
			}
		}

		for(int i=0; i<M; i++) { // 세로
			for(int j=0; j<N; j++) { // 가로

				if(visit[i][j] == false) {
					char color = map[i][j];
					count = 0;
					DFS(j, i, color);

					if(color == 'W') {
						white_count += count * count;
					}
					else {
						black_count += count * count;
					}
				}
		

			}
		}

		System.out.println(white_count + " " + black_count);

	}

	static void DFS(int x, int y, char color) {
		visit[y][x] = true;
		count += 1;

		for(int i=0; i<4; i++) {
			now_y = y + dirY[i];
			now_x = x + dirX[i];

			if(Range_check() == true && map[now_y][now_x]==color && visit[now_y][now_x] == false ) {
				DFS(now_x, now_y, map[now_y][now_x]);
			}

		}

	}	

	static boolean Range_check() {
		return (0 <= now_y && now_y < M && 0 <= now_x && now_x < N);
	}

}
