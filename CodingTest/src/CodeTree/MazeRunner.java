package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MazeRunner { // 메이즈러너
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}, map;
	static int exitX, exitY, minX, minY, N, M, K, answer, startX, startY, endX, endY;
	static ArrayList<Candidate>[][] cadidates;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		cadidates = new ArrayList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				cadidates[i][j] = new ArrayList<>();
			}
		}
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cadidates[x][y].add(new Candidate(x, y));
		}
		st = new StringTokenizer(br.readLine());
		exitX = Integer.parseInt(st.nextToken());
		exitY = Integer.parseInt(st.nextToken());

		while(K-- > 0 && M>0) {
			// 이동
			move();
			//System.out.println("이동 후");
			//print();
			
			// 정사각형 구하기
			int n = getRectangle();	
			
			// 시계 90도 회전			
			rotate(n);		
			//System.out.println("회전 후");
			//print();
		}
		sb.append(answer).append("\n").append(exitX).append(" ").append(exitY);
		System.out.println(sb.toString());
	}
	
	private static void print() {
		System.out.println("----------------------------------- 내구성");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}

		System.out.println("------------------------------------ 사람수 ");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(cadidates[i][j].size()+" ");
			}System.out.println();
		}
	}

	private static void rotate(int n) {
		// 회전하면서 내구도 1씩 깎기, cadidates도 돌리기..
		int[][] temp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			temp[i] = map[i].clone();
		}
		ArrayList<Candidate> tempList[][] = new ArrayList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			tempList[i] = cadidates[i].clone();
		}
		
//		System.out.println("시작 "+startX+" "+startY+"   : "+n);
//		System.out.println("끝점 "+endX+" "+endY+"   : "+n);
		boolean change = false;
		for(int j=startY, j2=startX; j<=endY; j++, j2++) {
			for(int i=startX, i2=endY; i<=endX; i++, i2--) {
				if(i == exitX && j == exitY && !change) {
					exitX = j2;
					exitY = i2;
					change = true;
					//System.out.println("출구   ~~~ "+j2+" "+i2);
				}
//				System.out.println(i+"|"+j);
//				System.out.println((j2)+"|"+(i2));
//				System.out.println("-----");
				temp[j2][i2] = map[i][j]-1;
				tempList[j2][i2] = cadidates[i][j];
			}
		}
		map = temp;
		cadidates = tempList;
	}
	private static int getRectangle() {
		// 모든 참가자의 위치와 출구 위치의 최단 거리 구하기
		PriorityQueue<Rectangle> rectangles = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(cadidates[i][j].isEmpty()) continue;
				rectangles.offer(new Rectangle(i, j));
			}
		}
		// 가장 작은 정사각형의 좌표
		minX = rectangles.peek().x;
		minY = rectangles.peek().y;
		
		int n = Math.max((Math.abs(exitX-minX)), (Math.abs(exitY-minY))) + 1; // 정사각형 변 길이 구하기
		//System.out.println("exit "+exitX+" "+exitY);
		//System.out.println("참가자 "+minX+" "+minY);
		
		A:for(int x=1; x<=N-n+1; x++) {
			for(int y=1; y<=N-n+1; y++) {
				int eX = x + n - 1;
				int eY = y + n - 1;
				if(x<=exitX && x<=minX && eX>=exitX && eX>=minX &&
						y<=exitY && y<=minY && eY>=exitY && eY>=minY
						) {
					startX = x;
					startY = y;
					endX = eX;
					endY = eY;
					break A;
				}
			}
		}
		return n;
	}
	private static void move() {
		// 가상 temp에 모두 이동 시키기
		ArrayList<Candidate>[][] temp = new ArrayList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				temp[i][j] = new ArrayList<>();
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(cadidates[i][j]==null || cadidates[i][j].isEmpty()) continue;
				// 4방향 모두 확인해서 최단 거리 가까운 곳으로 이동
				//System.out.println(exitX+" 출구는 ? "+exitY);
				//System.out.println(i+" 현재 위치 ? "+j);
				boolean moving = false;
				int minDist = Math.abs(exitX-i)+Math.abs(exitY-j);
				int minX = i, minY = j;
				for(int d=0; d<4; d++) {
					int nx = i + dir[d][0];
					int ny = j + dir[d][1];
					if(nx<1 || nx<1 || nx>=N+1 || ny>=N+1 || map[nx][ny] > 0) continue;
					int currentDist = Math.abs(exitX-nx)+Math.abs(exitY-ny);
					if(minDist <= currentDist) continue;
					minX = nx;
					minY = ny;
					minDist = currentDist;
					//System.out.println("d "+d +"  "+nx + "  "+ny+" currentDist "+ currentDist);
					moving = true;
				}
				if(minX == exitX && minY == exitY) {
					M -= cadidates[i][j].size();
				}else {
					temp[minX][minY] = cadidates[i][j];
				}
				if(moving) answer++;
			}
		}
		cadidates = temp;
	}
	static class Candidate {
		int x, y;

		public Candidate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static class Rectangle implements Comparable<Rectangle>{
		int x, y;

		public Rectangle(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Rectangle o) {
			int myDist = (Math.abs(exitX-this.x) + Math.abs(exitY-this.y));
			int yourDist = (Math.abs(exitX-o.x) + Math.abs(exitY-o.y));
			if(myDist == yourDist) {
				if(this.x == o.x) {
					return this.y - o.y;
				}return this.x - o.x;
			}return myDist - yourDist;
		}
	}
}
