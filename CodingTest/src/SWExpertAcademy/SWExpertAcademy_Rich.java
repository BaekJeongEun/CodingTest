package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWExpertAcademy_Rich {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int N,M,Q;
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> row[] = new PriorityQueue[N+1];
			PriorityQueue<Integer> col[] = new PriorityQueue[M+1];
			int[][] arr = new int[N+1][M+1];

			for(int i=1; i<=N; i++) {
				row[i] = new PriorityQueue<>();
			}
			for(int i=1; i<=M; i++) {
				col[i] = new PriorityQueue<>();
			}
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				for(int j=1; j<=M; j++) {
					row[i].offer(num);
					col[j].offer(num);
					arr[i][j] = num;
				}
			}
			int sum = 0;
			for(int q=0; q<Q; q++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				row[r].offer(num);
				col[c].offer(num);
				arr[r][c] = num;
				
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=M; j++) {
						int now = arr[i][j];
						if(row[i].peek() < now && col[i].peek() < now) {
							sum++;
						}
					}
				}
			}
			sb.append("#"+tc+" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
