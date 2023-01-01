package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon9205 { // 맥주 마시면서 걸어가기 (G5)
	static Point home, festival;
	static ArrayList<Point> convenient;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()); // 집
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			convenient = new ArrayList<>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				convenient.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			st = new StringTokenizer(br.readLine());
			festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Queue<Point> q = new ArrayDeque<>();
			boolean[] visit = new boolean[n];
			q.add(home);
			boolean exit = false;
			while(!q.isEmpty()) {
				Point now = q.poll();
				int x = now.x;
				int y = now.y;
				if(Math.abs(x-festival.x)+Math.abs(y-festival.y)<=1000) {
					exit = true;
					break;
				}
				for(int i=0; i<n; i++) {
					if(!visit[i]) {
						int nx = convenient.get(i).x, ny = convenient.get(i).y;
						int dist = Math.abs(x-nx)+Math.abs(y-ny);
						if(dist <= 1000) {
							visit[i] = true;
							q.add(new Point(nx, ny));
						}
					}
				}
			}
			sb.append(exit? "happy\n" : "sad");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
