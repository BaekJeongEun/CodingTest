package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1979 { // 어디에 단어가 들어갈 수 있을까

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	int arr[][] = new int[N][N];
        	int total_sum=0;
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int width_sum = 0;
        		for(int j=0; j<N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        			// 가로줄 확인
        			if(arr[i][j]==0) { // 0 마주치면 초기화
        				// 가로줄에 K개 연속 있었는지
        				if(width_sum == K) {
                			total_sum++;
                		}
        				width_sum=0;
        				continue;
        			}
        			if(arr[i][j]==1) {
        				width_sum++;
        			}
        		}
        		// 가로줄에 K개 연속 있었는지
				if(width_sum == K) {
        			total_sum++;
        		}
        		
        	}
        	// 세로줄 K개 확인
        	for(int i=0; i<N; i++) {
        		int height_sum = 0;
        		for(int j=0; j<N; j++) {
        			if(arr[j][i]==0) { // 0 마주치면 초기화
        				// 세로줄에 K개 연속 있었는지
                		if(height_sum == K)
                			total_sum++;
        				height_sum=0;
        				continue;
        			}
        			if(arr[j][i]==1) {
        				height_sum++;
        			}
        		}
        		// 세로줄에 K개 연속 있었는지
        		if(height_sum == K)
        			total_sum++;
        	}
        	System.out.println("#"+tc+" "+total_sum);
        }
	}

}
