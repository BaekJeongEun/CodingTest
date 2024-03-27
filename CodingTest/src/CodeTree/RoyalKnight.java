package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class RoyalKnight { // 왕실의 기사 대결 (G3)
	static int L, N, Q;
	static Set<Integer> pick;
	static Knight[] knights;
	static int[][] knightIdx, damage, dir= {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		pick = new HashSet();
		knightIdx = new int[L][L];
		damage = new int[L][L];
		knights = new Knight[N+1];
		// 체스판 정보
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<L; j++) {
				damage[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// N개의 기사
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Knight knight = new Knight(i, x, y, h, w, k);
			knights[i] = knight;
			for(int j=x; j<x+h; j++) {
				for(int l=y; l<y+w; l++) {
					knightIdx[j][l] = i;
				}
			}
		}
		// 명령
		while(Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			// 기사 이동
			pick = new HashSet<>();
			if(knights[i] != null) {
				knightMove(i, d);
			}
			
			// 기사들 재정비
			setting();
			//print();
		}
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(knights[i] == null) continue;
			answer += (knights[i].originK - knights[i].k);
		}
		System.out.println(answer);
	}

	private static void setting() {
		knightIdx = new int[L][L];
		for(int d=1; d<=N; d++) {
			if(knights[d] == null) continue;
			Knight knight = knights[d];
			int idx = knight.idx;
			int x = knight.x;
			int y = knight.y;
			int h = knight.h;
			int w = knight.w;
			for(int i=x; i<x+h; i++) {
				for(int j=y; j<y+w; j++) {
					knightIdx[i][j] = idx;
				}
			}
		}
	}
	private static void knightMove(int target, int d) {
		Queue<Knight> q = new ArrayDeque<>();
		q.offer(knights[target]);
		while(!q.isEmpty()) {
			Knight now = q.poll();
			int idx = now.idx;
			int x = now.x;
			int y = now.y;
			int h = now.h;
			int w = now.w;
			// 현재 기사가 한 칸 이동했을 때
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			
			// 움직인 범위 내에 다른 기사 있는지
			for(int i=nx; i<nx+h; i++) {
				for(int j=ny; j<ny+w; j++) {
					if(i<0 || j<0 || i>=L || j>=L || damage[i][j]==2) { // 벽이 있거나 체스판 벗어나면
						return;
					}
					if(knightIdx[i][j] != 0 && knightIdx[i][j] != idx) { // 다른 기사가 있다면
						pick.add(knightIdx[i][j]);
						Knight next = knights[knightIdx[i][j]];
						q.offer(next);
					}
				}
			}
		}
		// 데미지 입은 기사들
		for(Integer idx : pick) {
			if(idx == target) continue;
			Knight knight = knights[idx];
			int x = knight.x += dir[d][0];
			int y = knight.y += dir[d][1];
			int h = knight.h;
			int w = knight.w;
			
			// damage 입기
			for(int i=x; i<x+h; i++) {
				for(int j=y; j<y+w; j++) {
					if(damage[i][j] == 1) {
						knight.k--;
					}
				}
			}
			if(knight.k <= 0) {
				knights[idx]=null;
			}
		}
		// 명령 받은 기사는 좌표이동만 함
		knights[target].x += dir[d][0];
		knights[target].y += dir[d][1];
	}
	static class Knight {
		int idx, x, y, h, w, k, originK;
		public Knight(int idx, int x, int y, int h, int w, int k) {
			super();
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.h = h;
			this.w = w;
			this.k = k;
			this.originK = k;
		}
	}
}
