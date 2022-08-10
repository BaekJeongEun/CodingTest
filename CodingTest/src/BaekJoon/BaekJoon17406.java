package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon17406 { // 배열 돌리기 (G4)
	
	public static int N, M, K, r, c, s, min;
	public static boolean[] visit;
	public static LinkedList<String> commandList = new LinkedList<>();
	public static LinkedList<String> sequence = new LinkedList<>();
	public static int[][] arr, copyArr;
	public static int[] dy = {1, 0, -1, 0};
	public static int[] dx = {0, 1, 0, -1};
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[K];
		arr = new int[N][M];
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		for (int i = 0; i < K; ++i) {
			commandList.add(br.readLine());
		}
		
		permutation(0);
		
		System.out.println(min);
	}
	
	public static void permutation(int cnt) {
		if (cnt == K) {
			copyArr = new int[N][M];
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					copyArr[i][j] = arr[i][j];
				}
			}
			
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(sequence.get(i));
				int r = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				int s = Integer.parseInt(st.nextToken());
				int stY = r-s;
				int stX = c-s;
				int enY = r+s;
				int enX = c+s;
				
				while (stY < enY && stX < enX) {
					turn(stY++, stX++, enY--, enX--);
				}
			}
			for (int i = 0; i < N; ++i) {
				int sum = 0;
				
				for (int j = 0; j < M; ++j) {
					sum += copyArr[i][j];
				}
				min = (min > sum) ? sum : min;
			}
			return;
		}
		
		for (int i = 0; i < K; ++i) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			sequence.add(commandList.get(i));
			permutation(cnt + 1);
			visit[i] = false;
			sequence.removeLast();
		}
	}
	
	public static void turn(int stY, int stX, int enY, int enX) {
		int y = stY;
		int x = stX;
		int dir = 0;
		int temp = copyArr[y][x];
		
		while (dir < 4) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			if (ny == stY && nx == stX) {
				copyArr[y][x] = temp;
				return;
			}
			
			if (ny < stY || nx < stX || ny > enY || nx > enX) {
				dir++;
				continue;
			}
			
			copyArr[y][x] = copyArr[ny][nx];
			
			y = ny;
			x = nx;
		}
	}
}