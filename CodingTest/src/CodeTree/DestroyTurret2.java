package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DestroyTurret2 { // 포탑 부수기(G1)
	static int N, M, K, time = 1, minTime = Integer.MAX_VALUE;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}, {1,1},{1,-1}, {-1, 1}, {-1,-1}};
	static int[][] visit;
	static Turret[][] arr;
	static ArrayList<Turret> list, pick;
	static Turret attacker, defender;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new Turret[N][M];
		list = new ArrayList<>();
		pick = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 0) continue;
				arr[i][j] = new Turret(i, j, now, 0, false);
			}
		}
		while(K-- > 0) {
			//System.out.println("=================================================================== "+K);
			if(checkMap()) {
				break;
			}
			Collections.sort(list);
			attacker = list.get(0);
			defender = list.get(list.size()-1);

			//System.out.println("공격  "+attacker);
			//System.out.println("피해  "+defender);
			// 공격자 선정
			attacker.power += (N+M); // 공격력 증가
			attacker.attackTime = time;
			attacker.attack = true;
			// 피해자 선정
			defender.attack = true;
			if(attacker.x == defender.x && attacker.y == defender.y) break;
			// 공격자의 공격
			// (1) 레이저 공격
			if(laser()) { // 레이저 도달 가능한지
				for(int i=0; i<pick.size(); i++) {
					int x = pick.get(i).x;
					int y = pick.get(i).y;
					if(x == attacker.x && y == attacker.y) continue;
					if(x == defender.x && y == defender.y) {
						defender.power -= attacker.power;
					}else {
						arr[x][y].power -= attacker.power/2;
						arr[x][y].attack = true;
					}
				}
			}else { // (2) 포탄 공격
				bomb();
			}
			//print();
			setTurret();
			time++;
			//print();
		}
		checkMap();
		Collections.sort(list);
		defender = list.get(list.size()-1);
		System.out.println(defender.power);
	}
	private static void print() {
		System.out.println("===============================print ");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j]==null?"0 ":arr[i][j].power+" ");
			}System.out.println();
		}
	}
	private static void setTurret() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == null) continue;
				if(arr[i][j].power <= 0) {
					arr[i][j] = null;
					continue;
				}
				if(arr[i][j].attack) { 
					arr[i][j].attack = false;
					continue;
				}
				arr[i][j].power++;
			}
		}
	}
	private static void bomb() {
		// 공격 대상 피해
		defender.power -= attacker.power;
		// 포탄 경계 지역 포탑 피해
		int x = defender.x;
		int y = defender.y;
		for(int d=0; d<8; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(nx<0) nx = N-1;
			else if(nx>=N) nx = 0;
			if(ny<0) ny = M-1;
			else if(ny>=M) ny = 0;
			if(arr[nx][ny] == null) continue;
			if(nx == attacker.x && ny == attacker.y) continue;
			arr[nx][ny].power -= attacker.power/2;
			arr[nx][ny].attack = true;
		}
	}
	private static boolean laser() {
		// 공격자에서 피해자까지 최단 경로 찾기
		minTime = Integer.MAX_VALUE;
		visit = new int[N][M];
		for(int i=0;i<visit.length;i++) {
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		pick.clear();
		bfs();
		return !pick.isEmpty();
	}
	
	private static void bfs() {
		Queue<Turret> q = new LinkedList<>();
		q.add(new Turret(attacker.x, attacker.y, 0));
		visit[attacker.x][attacker.y] = 0;
		while(!q.isEmpty()) {
			Turret now = q.poll();
			int x = now.x;
			int y = now.y;
			int time = now.time;
			if(minTime < time || visit[x][y] < time) {
				break;
			}
			if(x == defender.x && y == defender.y) {
				Turret temp = now;
				while(temp !=null) {
					pick.add(0, temp);
					temp = temp.pre;
				}
				break;
			}
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0) nx = N-1;
				else if(nx>=N) nx = 0;
				if(ny<0) ny = M-1;
				else if(ny>=M) ny = 0;
				if(arr[nx][ny] == null || visit[nx][ny] < time+1) continue; // 부서진 포탑 못 지남
				visit[nx][ny] = time+1;
				Turret next1 = new Turret(nx, ny, time+1);
				next1.pre = now;
				q.add(next1);
			}
		}
	}
	private static boolean checkMap() {
		list.clear();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] != null) {
					list.add(arr[i][j]);
				}
			}
		}
		return list.size() == 1 ? true : false;
	}
	static class Turret implements Comparable<Turret>{
		int x, y, power, attackTime, time;
		Turret pre;
		boolean attack = false;
		public Turret(int x, int y, int power, int attackTime, boolean attack) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
			this.attackTime = attackTime;
			this.attack = attack;
		}
		public Turret(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public int compareTo(Turret o) {
			if(this.power == o.power) {
				if(this.attackTime == o.attackTime) {
					if((this.x+this.y) == (o.x+o.y)) {
						return o.y - this.y; // 열이 더 큰 놈, 내림차순
					}
					return (o.x+o.y) - (this.x+this.y); // 오름차순
				}
				return o.attackTime - this.attackTime; // 최근 공격한 포탑, 내림차순
			}
			return this.power - o.power; // 공격력 약한 놈, 오름차순
		}
		@Override
		public String toString() {
			return "Turret [x=" + x + ", y=" + y + ", power=" + power + ", attackTime=" + attackTime + "]";
		}
		
	}
}
