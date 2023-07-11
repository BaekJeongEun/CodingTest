package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWExpertAcademy_Manitto {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 학생
			int M = Integer.parseInt(st.nextToken()); // 마니또 관계수
			int min = Integer.MAX_VALUE;
			ArrayList<int[]> arr[] = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				arr[i] = new ArrayList<>();
			}
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken()); // from
				int Y = Integer.parseInt(st.nextToken()); // to
				int Z = Integer.parseInt(st.nextToken()); // cost
				arr[X].add(new int[] {Y, Z});
			}
			for(int i=1; i<=N; i++) { // 1부터 시작
				PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[1] - o2[1];
					}
				});
				boolean[] visit = new boolean[N+1];
				q.offer(new int[] {i, 0});
				A:while(!q.isEmpty()) {
					int[] now = q.poll();
					int from = now[0];
					int cost = now[1];
					for(int cur = 0; cur<arr[from].size(); cur++) {
						if(visit[arr[from].get(cur)[0]]) continue;
						visit[arr[from].get(cur)[0]] = true;
						q.offer(new int[] {arr[from].get(cur)[0], cost+arr[from].get(cur)[1]});
						if(i == arr[from].get(cur)[0]) {
							// 시작지점과 같다면 도착한 것
							min = Integer.min(min, cost+arr[from].get(cur)[1]);
							break A;
						}
					}
				}
			}
			sb.append("#"+tc+" ").append((min == Integer.MAX_VALUE) ? "-1" : min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
