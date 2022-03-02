package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2167 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] arr = new int[r][c];
		
		for(int i=0; i<r; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st2.nextToken())-1;
			int start_y = Integer.parseInt(st2.nextToken())-1;
			int end_x = Integer.parseInt(st2.nextToken())-1;
			int end_y = Integer.parseInt(st2.nextToken())-1;
			int sum = 0;
			for(int j=start_y; j<=end_y; j++) {				
				for(int k=start_x; k<=end_x; k++) {
					sum += arr[k][j];
				}
			}
			System.out.println(sum);
		}
	}

}
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BaekJoon2167 {
//
//	public static void main (String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int[][] arr = new int[N+1][M+1];
//		for(int i=1;i<=N;i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=1;j<=M;j++) {
//				arr[i][j] += Integer.parseInt(st.nextToken())+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
//			}
//		}
//		int K = Integer.parseInt(br.readLine());
//		for(int l=0;l<K;l++) {
//			int i,j,x,y,sum=0;
//			st = new StringTokenizer(br.readLine());
//			i = Integer.parseInt(st.nextToken());
//			j = Integer.parseInt(st.nextToken());
//			x = Integer.parseInt(st.nextToken());
//			y = Integer.parseInt(st.nextToken());
//		    sum = arr[x][y]-arr[i-1][y]-arr[x][j-1]+arr[i-1][j-1];
//			System.out.println(sum);
//		}
//	}
//
//}
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BaekJoon2167 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int r = Integer.parseInt(st.nextToken());
//		int c = Integer.parseInt(st.nextToken());
//		int[][] arr = new int[r][c];
//		
//		for(int i=0; i<r; i++) {
//			StringTokenizer st1 = new StringTokenizer(br.readLine());
//			for(int j=0; j<c; j++) {
//				arr[i][j] = Integer.parseInt(st1.nextToken());
//			}
//		}
//		int tc = Integer.parseInt(br.readLine());
//		for(int i=0; i<tc; i++) {
//			StringTokenizer st2 = new StringTokenizer(br.readLine());
//			int start_x = Integer.parseInt(st2.nextToken())-1;
//			int start_y = Integer.parseInt(st2.nextToken())-1;
//			int end_x = Integer.parseInt(st2.nextToken())-1;
//			int end_y = Integer.parseInt(st2.nextToken())-1;
//			int sum = 0;
//			for(int j=start_x; j<=end_x; j++) {				
//				for(int k=start_y; k<=end_y; k++) {
//					sum += arr[j][k];
//				}
//			}
//			System.out.println(sum);
//		}
//	}
//
//}
