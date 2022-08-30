package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWExpertAcademy1233 { // 사칙연산 유효성 검사 D4

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int result = 1;
			int N = Integer.parseInt(br.readLine());
			String[] operate = new String[N+1];
			if(N % 2 == 0) result=0;
			for(int i=1; i<=N; i++) {
				String[] node = br.readLine().split(" ");
				if(result!=0 && Character.isDigit(node[1].charAt(0)) && node.length == 4) { // 나는 숫자인데 자식이 있으면 안 됨
					result = 0;
				}
				if(result!=0 && !Character.isDigit(node[1].charAt(0)) && node.length == 2) { // 나는 연산자인데 자식이 없으면 안 됨
					result = 0;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
