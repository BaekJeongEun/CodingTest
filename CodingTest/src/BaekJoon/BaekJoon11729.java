package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon11729 { // 하노이 탑 이동 순서 (G5)

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		bw.write((int) (Math.pow(2, N) - 1) + "\n");
 
		Hanoi(N, 1, 2, 3);
		
		bw.flush();
		bw.close();
	}
 
	public static void Hanoi(int N, int start, int mid, int to) throws IOException {
		if (N == 1) {
			bw.write(start + " " + to + "\n");
			return;
		}
 
		Hanoi(N - 1, start, to, mid);
		sb.append(start + " " + to + "\n");
		Hanoi(N - 1, mid, start, to);
	}

}
