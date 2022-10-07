package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon17143 { // 낚시왕 (G1)
	static int R, C, M, total;
	static Point[][] arr;
	static Queue<Point> list = new ArrayDeque();
	static int[][] dir = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상1, 하2, 우3, 좌4

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Point[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Point now = new Point(r, c, s, d, z);
			arr[r][c] = now;
		}
		for (int i = 1; i <= C; i++) {
			total += fishing(i);
			move();
		}
		System.out.println(total);
	}

	/**
	 * 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
	 */
	private static int fishing(int king) {
		int size = 0;
		for (int r = 1; r <= R; r++) {
			if (arr[r][king] != null) {
				size = arr[r][king].z;
				arr[r][king] = null;
				break;
			}
		}
		

		for(int a=1; a<=R; a++) {
			for(int b=1; b<=C; b++) {
				if(arr[a][b] != null)
					System.out.print(arr[a][b].z);
				else System.out.print("+");
			}System.out.println();
		}	
		
		return size;
	}

	/**
	 * 상어가 이동한다.
	 */
	private static void move() {
		list = new ArrayDeque<>();
		for (int i = 1; i <= R; i++)
			for (int j = 1; j <= C; j++) {
				if (arr[i][j] == null)
					continue;
				Point now = arr[i][j];
				int s = now.s;
				int d = now.d;
				int z = now.z;
				int r = now.r, c = now.c;
				int dist = 0;
				if (d <= 2) { // 상, 하 일 경우 c 고정
					dist = s % (R * 2 - 2);
					while (dist-- > 0) {
						
						if (d == 1) { // 상
							r--;
						} else { // 하
							r++;
						}
						if (r == 0) { // 상방향으로 갔다가 범위 벗어나면
							d = 2; // 아래 방향으로 바꿔
							r = 2; // 위치도 +1
						} else if (r == R + 1) { // 하
							d = 1;
							r = R - 1;
						}						 
					}
				} else { // 좌, 우 일 경우 r 고정
					dist = s % (C * 2 - 2);
					while (dist-- > 0) {
						if (d == 3) { // 우
							c++;
						} else { // 좌
							c--;
						}
						if (c == C + 1) { // 우
							d = 4;
							c = C - 1;
						} else if (c == 0) { // 좌
							d = 3;
							c = 2;
						}
					}
				}
				list.offer(new Point(r, c, s, d, z));
				
				
			}

		arr = new Point[R + 1][C + 1];
		int size = list.size();
		for (int s = 0; s < size; s++) {
			Point now = list.poll(); // 현재 들어갈 상어
			Point post = arr[now.r][now.c]; // 기존 map에 존재하는 상어
			if (post == null) { // 비어 있으면 넣기
				arr[now.r][now.c] = now;
			} else if (post.z < now.z) { // 비어있지 않고, 지금 상어 크기가 더 크다면
				arr[now.r][now.c] = now;
			}
		}

		
	}

	private static void print() {
		for(int r=1; r<=R; r++) {
			for(int c=1; c<=C; c++) {
				if(arr[r][c] != null)
					System.out.print(arr[r][c].z);
				else System.out.print("+");
			}System.out.println();
		}
	}
	private static class Point {
		int r, c, s, d, z;

		public Point(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}
}