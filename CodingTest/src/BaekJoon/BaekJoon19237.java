package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon19237 { // 어른 상어 (G2)
	static int N, M, K;
	static ArrayList<int[]> map[][];
	static Shark sharks[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 격자 크기
		M = Integer.parseInt(st.nextToken()); // 상어 수
		K = Integer.parseInt(st.nextToken()); // 냄새
		map = new ArrayList[N][N]; // 상어 번호, 냄새
		int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		sharks = new Shark[M+1]; // 상어 리스트
		for(int i=1; i<=M; i++) {
			sharks[i]= new Shark();
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) continue;
				map[i][j].add(new int[] {num, K}); // 번호 , 냄새
				sharks[num].x = i;
				sharks[num].y = j;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			sharks[i].d = (Integer.parseInt(st.nextToken())-1); // 초기 방향
		}
		for(int s=1; s<=M; s++) {
			ArrayList<int[][]> dir = new ArrayList<>();
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				int[][] temp = new int[4][2];
				for(int j=0; j<4; j++) {
					temp[j] = direction[Integer.parseInt(st.nextToken())-1];
				}
				dir.add(temp);
			}
			sharks[s].dir = dir;
		}
		int answer = 0;
		while(M > 1) {
			// 냄새 줄어들고, 0이 된 곳 없애기
			removeSmell();
			// 상어 이동, 냄새 뿌리기
			moveShark();
			answer++;
		}
		System.out.println(answer);
	}
	private static void removeSmell() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ArrayList<int[]> temp = map[i][j];
				for(int s=0; s<temp.size(); s++) {
					temp.get(s)[1]--;
					if(temp.get(s)[1] <= 0 || sharks[temp.get(s)[0]] == null) { // 0번호, 1냄새
						temp.remove(s);
						s--;
					}
				}
			}
		}
	}
	private static void moveShark() {
		System.out.println("moveShark");
		int[][] sharkNum = new int[N][N];
		A:for(int s=1; s<=M; s++) {
			if(sharks[s] == null) continue;
			int x = sharks[s].x;
			int y = sharks[s].y;
			int d = sharks[s].d;
			int[][] dir = sharks[s].dir.get(d);
			// 냄새 뿌리기
			map[x][y].add(new int[] {s, K});
			int myNumDir = -1;
			for(int i=0; i<4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				// 작은 번호 상어만 남기기
				if(nx<0 || ny<0 || nx>=N || ny>=N) {
					continue;
				}
				if(map[nx][ny].size() == 0 && sharkNum[nx][ny] == 0) { // 아무 냄새 없는 칸
					sharkNum[nx][ny] = s+1;
					sharks[s].x = nx;
					sharks[s].y = ny;
					sharks[s].d = i;
					continue A;
				}else {
					// 내 냄새가 있는지
					ArrayList<int[]> temp = map[nx][ny];
					for(int[] t : temp) {
						if(t[0] == s) { // 내 번호 있다
							myNumDir = i;
						}
					}
				}
			}
			if(myNumDir != -1) {
				int nx = x + dir[myNumDir][0];
				int ny = y + dir[myNumDir][1];
				if(sharkNum[nx][ny] == 0) { // 아무도 없는 칸
					sharkNum[nx][ny] = s;
					sharks[s].x = nx;
					sharks[s].y = ny;
					sharks[s].d = myNumDir;
				}else {
					// 상어 잡아먹힘
					sharks[s] = null;
					M--;
				}
			}
		}
	}
	static class Shark {
		int x, y, d;
		ArrayList<int[][]> dir;
		public Shark(int d) {
			super();
			this.d = d;
		}
		public Shark() {
		}
	}
}
