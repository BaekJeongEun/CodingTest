package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BaekJoon1927 { // 최소 힙 (S2)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		PriorityQueue<Integer> arr = new PriorityQueue();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(!arr.isEmpty()) {
					sb.append(arr.poll()).append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else {
				arr.offer(num);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
