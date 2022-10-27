package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpertAcademy2112 { // 보호 필름
	static int D, W, K, total;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			total = Integer.MAX_VALUE;
			arr = new int[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(check()) {
				System.out.println("0");
			}else 
				dfs(0, 0);
			System.out.println(total+"\n");
		}

	}
	private static void dfs(int row, int cnt) {
		if(check()) {
			total = Math.min(total, cnt);
			return;
		}
		
		if(row == D || cnt>total) {
			return;
		}
		int tmp[] = Arrays.copyOf(arr[row], arr[row].length);
		// 그대로 보내기
		dfs(row+1, cnt);
		
		// A로 바꾸기
		Arrays.fill(arr[row], 1);
		dfs(row+1, cnt+1);
		
		// B로 바꾸기
		Arrays.fill(arr[row], 0);
		dfs(row+1, cnt+1);
		
		arr[row] = Arrays.copyOf(tmp, tmp.length);
	}
	private static boolean check() {
		for(int j=0; j<W; j++) {
			boolean sign = false;
			int cnt = 1;
			for(int i=1; i<D; i++) {
				if(arr[i-1][j] == arr[i][j]) {
					cnt++;
				}else {
					cnt = 1;
				}
				if(cnt == K) {
					sign = true;
					break;
				}
			}
			if(!sign) return false;
		}
		return true;
	}

}
