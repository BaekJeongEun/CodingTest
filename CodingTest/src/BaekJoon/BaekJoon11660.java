package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11660 { // 구간 합 구하기 5

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + (Integer.parseInt(str[j - 1]));
			}
		}
		
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(arr[i][j]+" ");
//			}System.out.println();
//		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			System.out.println(arr[endX][endY] -arr[endX][startY-1] -arr[startX-1][endY] + arr[startX-1][startY-1]);

		}

	}

}
