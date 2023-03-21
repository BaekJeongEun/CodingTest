package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BaekJoon11286 { // 절댓값 힙 (S1)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		PriorityQueue<Element> arr = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(!arr.isEmpty()) {
					sb.append(arr.poll().origin).append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else {
				arr.offer(new Element(num, Math.abs(num)));
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static class Element implements Comparable<Element> {
		int origin, trans;
		public Element(int origin, int trans) {
			super();
			this.origin = origin;
			this.trans = trans;
		}
		@Override
		public int compareTo(Element o) {
			if(this.trans == o.trans) {
				return this.origin - o.origin;
			}
			return this.trans - o.trans;
		}
	}
}
