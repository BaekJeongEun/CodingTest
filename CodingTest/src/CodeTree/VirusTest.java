package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VirusTest { // 바이러스 검사
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] store = new int[n];
		for(int i=0; i<n; i++) {
			store[i] = Integer.parseInt(st.nextToken()); // 각 식당 손님 수
		}
		st = new StringTokenizer(br.readLine());
		int LDR = Integer.parseInt(st.nextToken());
		int MBR = Integer.parseInt(st.nextToken());
		long answer = 0;
		for(int i=0; i<n; i++) {
			answer++;
			int customer = store[i] - LDR;
			if(customer <= 0) {
				customer = 0;
			}else if(customer % MBR == 0) {
				customer /= MBR;
			}else {
				customer = customer/MBR+1;
			}
			answer += customer;
		}
		System.out.println(answer);
	}

}
