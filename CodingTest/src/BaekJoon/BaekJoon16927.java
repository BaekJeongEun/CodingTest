package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16927 { // 배열 돌리기2(G5)
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
    	
    	int nN = N;
    	int nM = M;
    	for(int i=0; i<Math.min(M, N)/2; i++) {
    		/*
    		 * i : 회전을 시작할 좌표
    		 * 2*N + 2*M - 4 : 처음엔 가장 겉 테두리의 갯수, 그 다음엔 각 변 길이가 2씩 줄도록 해서 넣어줌
    		 */
    		rotate(i, 2*nN + 2*nM - 4);
    		nN -= 2;
    		nM -= 2;
    	}
    	
    	print();
    }
    
    static void rotate(int start, int len) {
    	int cir = R % len;
    	for(int t=0; t<cir; t++) {
    		int x = start;
    		int y = start;
    		
    		int temp = map[x][y]; 
    		
    		int idx = 0; 
    		while(idx < 4) { 
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			if(nx >= start && ny >= start && nx < N-start && ny < M-start) {
    				map[x][y] = map[nx][ny];
    				x = nx;
    				y = ny;
    			} 
    			else {
    				idx++;
    			}
    			
    		}
    		
    		map[start+1][start] = temp;
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
