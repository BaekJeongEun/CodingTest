package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class SWExpertAcademy1225 { // 암호생성기 (D3)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		Queue<Integer> q;
		
		for(int tc=1; tc<=10; tc++) {
			q = new LinkedList<>();
			br.readLine();
			st= new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				int n = Integer.parseInt(st.nextToken());
				q.offer(n);
			}
			
			int num = 1;
			int sub = 1;
			// 암호 생성하기
			while(num != 0) {
				if(sub==6) sub = 1;
				
				int temp = q.poll();
				num = temp - (sub++);
				if(num<=0) num=0;
				q.offer(num);
			}
			
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int size = q.size();
			for(int i=0; i<size; i++) {
				sb.append(q.poll()).append(" ");
			}
			
			System.out.println(sb);
		}
	}

}
