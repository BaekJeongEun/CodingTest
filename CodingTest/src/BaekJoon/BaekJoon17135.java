package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon17135 { // 캐슬 디펜스(G3)
	static int N, M, D, arr[][], temp[][], kill = 0, max = Integer.MIN_VALUE, size;
	static ArrayList<Integer> pickList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		D = Integer.parseInt(st.nextToken()); // 거리제한
		arr = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0);
		System.out.println(max);
	}

	private static void comb(int idx) {
		if (pickList.size() == 3) {
			startAttack();
			return;
		}
		for (int i = idx; i < M; i++) {
			pickList.add(i);
			comb(i + 1);
			pickList.remove(pickList.size()-1);
		}
	}

	private static void startAttack() {
		temp = new int[N][M];
		for (int i = 0; i < N; i++) { // 원본 복사
			System.arraycopy(arr[i], 0, temp[i], 0, M);
		}
		kill = 0; size = N;
		while (size > 0) {
			// 궁수 공격
			attack();
		}

		max = Math.max(max, kill);
	}

	private static void attack() {
		ArrayList<Point> enemy = new ArrayList<>();
		
		for (int a = 0; a < pickList.size(); a++) { 
			int min = Integer.MAX_VALUE;
			int minX = 0, minY = 0;
			for(int j=0; j<M; j++) {
				for(int i=size-1; i>=0; i--) {
					int dist = Math.abs(size-i)+Math.abs(pickList.get(a)-j);
					if(temp[i][j]==1 && dist <= D) {
						if(dist < min) {
							min = dist;
							minX = i;
							minY = j;
						}
					}
				}
			}
			if(min != Integer.MAX_VALUE)  {
				enemy.add(new Point(minX, minY));
			}
		}
		for(int i =0; i<enemy.size(); i++) {
			if(temp[enemy.get(i).x][enemy.get(i).y] != 0) {
				temp[enemy.get(i).x][enemy.get(i).y] = 0;
				kill++;
			}
		}
		size--;
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
