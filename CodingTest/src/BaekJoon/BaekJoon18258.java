package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon18258 { // 큐 2(S4)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				q.offer(X);
			} else if(str.equals("pop")) {
				if(!q.isEmpty()) {
					sb.append(q.poll()).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
			} else if(str.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if(str.equals("empty")) {
				if(!q.isEmpty()) {
					sb.append("0").append("\n");
				}else {
					sb.append("1").append("\n");
				}
			} else if(str.equals("front")) {
				if(!q.isEmpty()) {
					sb.append(q.peek()).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
			} else if(str.equals("back")) {
				if(!q.isEmpty()) {
					sb.append(q.peekLast()).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
			} 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
