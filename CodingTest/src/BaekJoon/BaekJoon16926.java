package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16926 { // 배열 돌리기1 (ㄴ1)
	static int N, M, R;
	static int min;
	static int[][] map;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken()); // 행 크기
    	M = Integer.parseInt(st.nextToken()); // 열 크기
    	R = Integer.parseInt(st.nextToken()); // 회전 횟수

    	map = new int[N][M];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	min = Math.min(N, M); 
    	
    	for(int i=1; i<=R; i++) {
    		rotate();
    	}
    	
    	print();
    }
    
    static void rotate() {
    	
    	for(int t=0; t<min/2; t++) { 
    		int x = t;
    		int y = t;
    		
    		int temp = map[x][y]; 
    		
    		int idx = 0; 
    		while(idx < 4) { 
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			if(nx < N-t && ny < M-t && nx >= t && ny >= t) {
    				map[x][y] = map[nx][ny];
    				x = nx;
    				y = ny;
    			} 
    			else {
    				idx++;
    			}
    			
    		}
    		
    		map[t+1][t] = temp;
    	}
    	
    }
    
    static void print() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			System.out.print(map[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
