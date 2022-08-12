package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon15686 { // 치킨 배달 (G5)
	static int N, M, min=Integer.MAX_VALUE;
	static int[][] arr;
	static ArrayList<Point> list = new ArrayList<>();
	static ArrayList<Point> house = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					list.add(new Point(i, j));
				}
				if(arr[i][j]==1) {
					house.add(new Point(i, j));
				}
			}
		}
		
		comb(0, 0, new ArrayList<>());
		System.out.println(min);
	}
	
	private static void comb(int idx, int cnt, ArrayList<Point> pickList) {
		if(cnt == M) {
			checkDist(pickList);
			return;
		}
		for(int i=idx; i<list.size(); i++) {
			pickList.add(list.get(i));
			comb(i+1, cnt+1, pickList);
			pickList.remove(list.get(i));
		}
	}

	private static void checkDist(ArrayList<Point> pickList) {
		int sum = 0;
		for(int h=0; h<house.size(); h++) {
			int dist = Integer.MAX_VALUE;
			for(int l = 0; l<pickList.size(); l++) {
				dist = Math.min(dist, Math.abs(pickList.get(l).x-house.get(h).x)+Math.abs(pickList.get(l).y-house.get(h).y));
			}
			sum += dist;
		}
		
		min = Math.min(min, sum);
	}

	static public class Point{
		int  x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
