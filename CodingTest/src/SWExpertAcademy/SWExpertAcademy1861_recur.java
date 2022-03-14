package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1861_recur {
	static int arr[][];
	static int max_room=0, max_count=0, cnt, N;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					bfs(i,j,arr[i][j]);
					cnt=0;
				}
			}
			System.out.println("#"+tc+" "+max_room+" "+max_count);
			max_room = 0;
			max_count = 0;
		}
	}
	static void bfs(int x, int y, int start_room) {
		cnt++;
		int cur_x = x;
		int cur_y = y;
		while(true) {
			boolean finish = false;
			for(int i=0; i<4; i++) {
				int new_x = cur_x+dx[i];
				int new_y = cur_y+dy[i];
				if(new_x>=0 && new_y>=0 && new_x<N && new_y<N &&arr[cur_x][cur_y]+1==arr[new_x][new_y]) {
					cnt++;
					cur_x = new_x;
					cur_y = new_y;
					finish = true; // 나보다 1 큰 애 찾았으면 사방 탐색 그만해도 돼. 새로 갱신된 자리로 사방 탐색 다시 시작하게 for문 처음부터 다시 돌자.
					break;
				}
			}
			if(!finish) // 나보다 1 더 큰 애 다 찾았고 더 이상 사방 탐색 못 해. 끝남.
				break;
		}
		// 시작 장소부터 시작해서 최대 갯수 찾았으니 비교해서 갱신하자.
		if(max_count < cnt) {
			max_room = start_room;
			max_count = cnt;
		}else if(max_count == cnt) {
			max_room = Math.min(max_room, start_room);
		}
	}

}
