package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1913 { // 달팽이 (S3)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		int loop = 1;
		int x = N/2;
		int y = N/2;
		int num = 1;
		arr[x][y] = num++;
		for(int i=1; i<=N/2; i++) {
			
			// 상 [-1, 0]
			for(int j=0; j<loop; j++) {
				x += -1;
				arr[x][y] = num++;
			}
			// 우 [0, 1]
			for(int j=0; j<loop; j++) {
				y += 1;
				arr[x][y] = num++;			
			}

			loop++;
			
			// 하 [1, 0]
			for(int j=0; j<loop; j++) {
				x += 1;
				arr[x][y] = num++;
			}

			// 좌 [0, -1]
			for(int j=0; j<loop; j++) {
				y += -1;
				arr[x][y] = num++;			
			}

			loop++;
		}
		
		for(int j=0; j<loop-1; j++) {
			x += -1;
			arr[x][y] = num++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(target == arr[i][j]) {
					x = i; y=j;
				}
				sb.append(arr[i][j]).append(" ");
			}
			if(i!=N) sb.append("\n");
		}
		sb.append(x+1).append(" ").append(y+1);
		System.out.println(sb);
	}

}
