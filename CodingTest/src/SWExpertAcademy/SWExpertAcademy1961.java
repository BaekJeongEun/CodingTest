package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1961 { // 숫자 배열 회전

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
     
        for(int tc=1; tc<=T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	String arr[][] = new String[N][N];
        	StringBuilder sb = new StringBuilder();
        	for(int i=0; i<N; i++) {
        		arr[i] = br.readLine().split(" ");
        	}
        	
        	// 3방향 회전
        	for(int r=0; r<N; r++) {
        		// 90도
        		for(int d=0; d<N; d++) {
        			// 출력 줄 이어 붙이기
        			sb.append(arr[N-d-1][r].toString());
        		}
        		sb.append(" ");
        		// 180도
        		for(int d=0; d<N; d++) {
        			// 출력 줄 이어 붙이기
        			sb.append(arr[N-r-1][N-d-1].toString());
        		}
        		sb.append(" ");
        		// 270도
        		for(int d=0; d<N; d++) {
        			// 출력 줄 이어 붙이기
        			sb.append(arr[d][N-r-1].toString());
        		}
        		sb.append("\n");
        	}
        	System.out.print("#"+tc+"\n"+sb);
        }
	}

}
