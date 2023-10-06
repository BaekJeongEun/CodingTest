package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class DestroyTurret {
	static int N, M, K;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static Turret[][] map;
	static ArrayList<Turret> turrets;
	static Turret attacker, target;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Turret[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 0) continue;
				map[i][j] = new Turret(i, j, now, 0, false); // x, y, 공격력, 공격한 시간, 공격 가해, 피해 여부
			}
		}
		A:while(true) {
			// q에 넣기, 만약 공격 안 받은 포탄이 없다면 종료
			boolean exit = true;
			turrets = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == null) continue;
					if(map[i][j].power <= 0) {
						map[i][j] = null;
						continue;
					}
					if(!map[i][j].attack) exit = false;
					turrets.add(new Turret(i, j, map[i][j].power, map[i][j].attackTime, map[i][j].attack));
				}
			}
			if(exit) break A;
			// 공격자 선정 (약한)
			attacker = getAttacker();
			
			// 대상자 선정 (강한) .reverse
			target = getTarget();
			
			// 레이저 공격
			if(!laser()) { // 실패하면 포탄
				// 포탄 공격
				bomb();
			}
		}		
	}
	private static void bomb() {
		// TODO Auto-generated method stub
		
	}
	private static boolean laser() {
		Queue<int[]> q = new ArrayDeque();
		q.offer(new int[] {attacker.x, attacker.y});
		boolean[][] visit = new boolean[N][M];
		visit[attacker.x][attacker.y] = true;
		Turret temp[][] = new Turret[N][M];
		for(int i=0; i<N; i++) {
			temp[i] = map[i].clone();
		}
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			ArrayList<int[]> route = temp[x][y].route;
			if(x == target.x && y == target.y) {
				map = temp;
				map[x][y].attack = true;
				map[x][y].power -= map[attacker.x][attacker.y].power;
				map[attacker.x][attacker.y].attack = true;
				return true;
			}
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx<0) nx = N;
				if(ny<0) ny = M;
				if(nx>=N) nx = 0;
				if(ny>=M) y = 0;
				if(temp[nx][ny] == null || visit[nx][ny]) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				temp[nx][ny].route.add(new int[] {nx, ny});
			}
		}
		
		return false; // 실패
	}
	private static Turret getTarget() {
		Collections.sort(turrets, Collections.reverseOrder());
		return turrets.get(0);
	}
	private static Turret getAttacker() {
		Collections.sort(turrets);
		return turrets.get(0);
	}
	
	static class TurretRoute {
		int x, y;
		ArrayList<int[]> route = new ArrayList<>();
		public TurretRoute(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Turret implements Comparable<Turret>{
		int x, y, power, attackTime;
		boolean attack;
		public Turret(int x, int y, int power, int attackTime, boolean attack) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
			this.attackTime = attackTime;
			this.attack = attack;
		}
		@Override
		public int compareTo(Turret o) {
			if(this.power == o.power) {
				if(this.attackTime == o.attackTime) {
					if((this.x+this.y) == (o.x+o.y)) {
						return o.y - this.y; // 열이 더 큰 놈, 내림차순
					}
					return (o.x+o.y) - (this.x+this.y); 
				}
				return o.attackTime - this.attackTime; // 최근 공격한 포탑, 내림차순
			}
			return this.power - o.power; // 공격력 약한 놈, 오름차순
		}
	}
}
