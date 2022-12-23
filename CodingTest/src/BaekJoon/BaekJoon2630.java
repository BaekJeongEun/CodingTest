package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon2630 { // 색종이 만들기 (S2)
	static int N, arr[][];
	static int white, blue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0, 0, N);
		sb.append(white+"\n").append(blue+"");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void recur(int x, int y, int size) {
		if(check(x, y, size)) {
			if(arr[x][y] == 0) white++;
			else blue++;
			return;
		}
		int half = size/2;
		recur(x, y, half);
		recur(x+half, y, half);
		recur(x, y+half, half);
		recur(x+half, y+half, half);
	}
	private static boolean check(int x, int y, int size) {
		int color = arr[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(arr[i][j] != color) return false;
			}
		}
		return true;
	}
}