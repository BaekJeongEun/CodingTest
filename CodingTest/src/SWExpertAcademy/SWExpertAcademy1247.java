package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWExpertAcademy1247 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int corpX = Integer.parseInt(st.nextToken());
			int corpY = Integer.parseInt(st.nextToken());
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			
			ArrayList<Point> arr = new ArrayList<>();
			for(int i=0; i<N; i++) {
				Point create = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				arr.add(create);
			}
			int nearst_idx = -1;
			Point nearst_point = new Point(corpX, corpX);
			int near_dist = Integer.MAX_VALUE;
			int sum = 0;
			while(!arr.isEmpty()) {
				near_dist = Integer.MAX_VALUE;
				for(int i=0; i<arr.size(); i++) {
					// 회사와 가까운 위치 찾기
					int dist = Math.abs(nearst_point.x - arr.get(i).x) + Math.abs(nearst_point.y - arr.get(i).y);
					if(near_dist>dist) {
						near_dist = dist;
						nearst_idx = i;
						nearst_point = new Point(arr.get(i).x, arr.get(i).y);
					}
				}
				// 회사와 가장 가까운 위치와의 거리 누적
				sum += near_dist;
				
				// 가까운 위치 삭제
				arr.remove(nearst_idx);
			}
			// 가장 최근 위치에서 집까지 거리 구하기
			sum += Math.abs(homeX-nearst_point.x) + Math.abs(homeY-nearst_point.y);
			
			System.out.println("#"+tc+" "+sum);
		}
	}
	static public class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}