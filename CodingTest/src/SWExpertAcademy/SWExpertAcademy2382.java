package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWExpertAcademy2382 { // 미생물 격리
	static int N, M, K;
	static int[][] dir = {{}, {-1,0}, {1,0}, {0,-1}, {0,1}}; // 상 하 좌 우
	static Bug arr[][];
	static ArrayList<Bug> bugList;
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
			K = Integer.parseInt(st.nextToken());
			arr = new Bug[N][N];
			bugList = new ArrayList<>();
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Bug bug = new Bug(x, y, n, d,n);
				arr[x][y] = bug;
				bugList.add(bug);
			}
			for(int t=0; t<M; t++) {
				// 미생물 이동
				int bugSize = bugList.size();
				for(int b=0; b<bugSize; b++) {
					Bug now = bugList.get(0);
					bugList.remove(0);
					int x = now.x;
					int y = now.y;
					int n = now.n;
					int d = now.d;
					
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					
					if(nx>0 && ny>0 && nx<N-1 && ny<N-1) { // 약품에 안 닿으면 그냥 옮겨도 됨
						bugList.add(new Bug(nx, ny, n, d, n));
					}else { // 약품에 닿으면
						if(d == 1) d = 2;
						else if(d==2) d =1;
						else if(d==3) d =4;
						else if(d==4) d =3;
						n/=2;
						bugList.add(new Bug(nx, ny, n, d, n));
					}
				}
				
				arr = new Bug[N][N];
				ArrayList<Bug> removeList = new ArrayList<>();
				for(int i=0; i<bugList.size(); i++) {
					Bug b = bugList.get(i);
					if(arr[b.x][b.y] == null) {
						arr[b.x][b.y] = b;
						arr[b.x][b.y].maxN = b.n;
					}else {
						int sumN = arr[b.x][b.y].n + b.n;
						if(arr[b.x][b.y].maxN < b.n) { // 최신 것이 더 크면 기존의 리스트에도 갱신해줘야 함
							arr[b.x][b.y].maxN = b.n;
							arr[b.x][b.y].d = b.d;
							arr[b.x][b.y].n = sumN;
						}else { // 기존 숫자가 더 크다면
							arr[b.x][b.y].n = sumN;
						}
					}
				}
				bugList.clear();
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(arr[i][j] != null) {
							bugList.add(arr[i][j]);
						}
					}
				}
			}
			int result = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] != null) {
						result += arr[i][j].n;
					}
				}
			}
			sb.append("#"+tc+" "+result+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class Bug{
		int x, y, n, d, maxD, maxN=0;

		public Bug(int x, int y, int n, int d, int maxN) {
			super();
			this.x = x;
			this.y = y;
			this.n = n;
			this.d = d;
			this.maxN = maxN;
		}

		@Override
		public String toString() {
			return "Bug [x=" + x + ", y=" + y + ", n=" + n + ", d=" + d + ", maxD=" + maxD + ", maxN=" + maxN + "]";
		}
		
	}
}
