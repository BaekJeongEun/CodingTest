package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon2075 { // N번째 큰 수(S2)
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0;i<N-1;i++) {
			pq.remove();
		}
		bw.write(pq.poll()+"");
		bw.flush();
		bw.close();
	}
}
