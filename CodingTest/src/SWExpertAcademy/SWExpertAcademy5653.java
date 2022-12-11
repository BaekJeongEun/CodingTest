package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademy5653 { // 줄기세포배양
	static int N, M, K;
	static Cell[][] arr;
	static int visit[][];
	static Queue<Cell> cell;
	static ArrayList<Cell> activeList;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			activeList = new ArrayList<>();
			cell = new PriorityQueue<>();
			arr = new Cell[701][701];
			int size = 350;
			for (int i = size; i < size + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = size; j < size + M; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num > 0) {
						Cell now = new Cell(i, j, num, num*2);
						arr[i][j] = now;
						activeList.add(now);
					}
				}
			}
			for (int i = 0; i < K; i++) {
				bfs(i);
			}

			sb.append(activeList.size()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void bfs(int t) {
		int size = activeList.size(); // 비활성, 활성 세포
		for(int s=0; s<size; s++) {
			Cell now = activeList.get(s);
			int x = now.x;
			int y = now.y;
			int num = now.num;
			int life = now.life;
			System.out.println(now);
			// 증식시켜야 할 세포들 큐에 담기
			if(life <= num) { // 활성화 됨
				arr[x][y].life--;
				activeList.add(new Cell(x, y, num, life-1));
				cell.offer(new Cell(x, y, num, life-1));
				continue;
			}else if(life > num) { // 아직 비활성이라 리스트에 넣어줌
				arr[x][y].life--;
				activeList.add(new Cell(x, y, num, life-1));
				continue;
			}else if(life == 0){ // 죽음
				size--;
				s--;
				cell.remove(now);
				activeList.remove(now);
			}
		}
		while(!cell.isEmpty()) {
			Cell now = cell.poll();
			int x = now.x;
			int y = now.y;
			int num = now.num;
			int life = now.life;
			for(int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(arr[nx][ny] == null || (arr[nx][ny].life!=0 && arr[nx][ny].num < num)) { // 죽은 세포 아니거나 내 숫자가 더 크다면 넣기
					arr[nx][ny] = now;
					activeList.add(now); // 증식된 친구들 넣기
				}
			}
		}
	}

	static private class Cell implements Comparable<Cell> {

		int x, y, life, num;
		public Cell(int x, int y, int num, int life) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.life = life;
		}

		@Override
		public int compareTo(Cell o) {
			return o.num - this.num;
		}

		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", num=" + num + "]";
		}
		
	}
}
