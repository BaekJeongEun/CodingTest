package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon17086 { // 아기 상어 2 (S2)
	static int n,m;
	static int dx[]= {0,0,1,-1,1,1,-1,-1};
	static int dy[]= {1,-1,0,0,1,-1,-1,1};
	static int[][] map;
	static int[][] dist;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new int[n][m];
		dist=new int[n][m];
		Queue<Shark> q=new LinkedList<Shark>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) {
					q.add(new Shark(j,i));
				}
			}
		}
		int answer=Integer.MIN_VALUE;
	
		while(q.size()!=0) {
			Shark cur=q.poll();
			int x=cur.x;
			int y=cur.y;
			for (int j = 0; j < 8; j++) {
				int yy=y+dy[j];
				int xx=x+dx[j];
				if(xx<0 || yy<0 || xx>=m || yy>=n)continue;
				if(dist[yy][xx]!=0 || map[yy][xx]==1)continue;
				dist[yy][xx]=dist[y][x]+1;
				if(dist[yy][xx]>answer)answer=dist[yy][xx];
				q.add(new Shark(xx,yy));
			}
		}
		System.out.println(answer);	
		
	}

	static class Shark{
		int x;
		int y;
		public Shark(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}

