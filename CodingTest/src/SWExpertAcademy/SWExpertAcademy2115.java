package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWExpertAcademy2115 { // 벌꿀 채취
	static int N,M,C, max, honeyMax;
	static int[][] arr;
	static boolean[] visit;
	static ArrayList<Point> honeyList;
	static int[] pickList;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			max = Integer.MIN_VALUE;
			honeyList = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			honeySpot();
			visit = new boolean[honeyList.size()];
			pickList = new int[2];
			comb(0, 0);
			sb.append("#"+tc+" "+max+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void comb(int idx, int cnt) {
		if(cnt == 2) {
			getHoney();
			return;
		}
		for(int i=idx; i<honeyList.size(); i++) {
			if(visit[i]) continue;
			visit[i] = true;
			pickList[cnt] = i;
			comb(i+1, cnt+1);
			visit[i] = false;
		}
	}
	private static void getHoney() {
		Point p1 = honeyList.get(pickList[0]);
		Point p2 = honeyList.get(pickList[1]);
		
		if(p1.x1 == p2.x1) {
			if(p1.y1 <= p2.y1 && p1.y2 >= p2.y1) {
				return;
			}
			if(p1.y1 <= p2.y2 && p1.y2 >= p2.y2) {
				return;
			}
			if(p2.y1 <= p1.y1 && p2.y2 >= p1.y1) {
				return;
			}
			if(p2.y1 <= p1.y2 && p2.y2 >= p1.y2) {
				return;
			}
		}
		
		int sum1 = 0, sumC1 = 0;
		int sum2 = 0, sumC2 = 0;
		ArrayList<Integer> honey1 = new ArrayList<>();
		ArrayList<Integer> honey2 = new ArrayList<>();
		for(int j=p1.y1; j<p1.y2; j++) {
			sum1 += arr[p1.x1][j] * arr[p1.x1][j];
			sumC1 += arr[p1.x1][j];
			honey1.add(arr[p1.x1][j]);
		}
		if(sumC1 > C) {
			honeyMax = Integer.MIN_VALUE;
			sum1 = heonySubSet(honey1, new boolean[honey1.size()]);
		}
		for(int j=p2.y1; j<p2.y2; j++) {
			sum2 += arr[p2.x1][j] * arr[p2.x1][j];
			sumC2 += arr[p2.x1][j];
			honey2.add(arr[p2.x1][j]);
		}
		if(sumC2 > C) {
			honeyMax = Integer.MIN_VALUE;
			sum2 = heonySubSet(honey2, new boolean[honey2.size()]);		
		}
		
		max = Math.max(max, sum1 + sum2);
	}
	private static int heonySubSet(ArrayList<Integer> honey, boolean[] visit) {
		subSet(0, honey, visit);
		return honeyMax;
	}
	private static void subSet(int cnt, ArrayList<Integer> honey, boolean[] visit) {
		if(cnt == honey.size()) {
			int sum = 0, c = 0;
			for(int i=0; i<honey.size(); i++) {
				if(visit[i]) {
					c += honey.get(i);
					sum += honey.get(i)*honey.get(i);
				}
			}
			if(c <= C) {
				honeyMax = Math.max(honeyMax, sum);
			}
			return;
		}
		visit[cnt] = true;
		subSet(cnt+1, honey, visit);
		visit[cnt] = false;
		subSet(cnt+1, honey, visit);
	}
	private static void honeySpot() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-M+1; j++) {
				honeyList.add(new Point(i, j, i, j+M));
			}
		}
	}
	static class Point{
		int x1, y1;
		int x2, y2;
		public Point(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		@Override
		public String toString() {
			return "Point [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
		}
		
	}
}
