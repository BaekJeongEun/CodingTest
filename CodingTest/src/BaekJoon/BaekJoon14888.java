package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon14888 { // 연산자 끼워넣기 (S1)
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] num, operation;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		operation = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		operate(0, num[0]);
		sb.append(max+"\n"+min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void operate(int cnt, int result) {
		if(cnt == num.length-1) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		for(int i=0; i<4; i++) {
			if(operation[i] > 0) {
				operation[i]--;
				if(i == 0) { // +
					operate(cnt+1, result+num[cnt+1]);
				}else if(i==1) { // -
					operate(cnt+1, result-num[cnt+1]);
				}else if(i==2) { // *
					operate(cnt+1, result*num[cnt+1]);
				}else { // /
					operate(cnt+1, result/num[cnt+1]);
				}
				operation[i]++;
			}
		}
	}
}