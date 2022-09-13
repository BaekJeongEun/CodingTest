package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpert1954 { // 달팽이 숫자 (D2)
	static int[][] arr;
	static int[][] dir= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상
	static int num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=TC; tc++) {

			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			num = 1;
			
			int loop = (N%2==0)? N/2: N/2+1;
			for(int i=0, j=N-i-1; i<loop; i++, j-=2) {
				// 달팽이 껍데기 만들기
				snail(i, j);
			}
			
			sb.append("#"+tc+"\n");
			int i=0;
			for(i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				if(i!=N-1)
					sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}
	private static void snail(int start, int loop) {
		int currentX = start;
		int currentY = start;
		arr[currentX][currentY] = num++;
		
		for(int d=0; d<4; d++) {
			if(d==3) loop -=1;
			for(int i=0; i<loop; i++) {
				currentX +=dir[d][0];
				currentY +=dir[d][1];
				
				arr[currentX][currentY] = num++;
			}
		}
		
	}

}
