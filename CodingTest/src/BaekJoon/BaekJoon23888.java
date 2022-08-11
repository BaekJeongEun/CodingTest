package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon23888 { // 등차수열과 쿼리(S1)

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long a = Long.parseLong(st.nextToken());
		long d = Long.parseLong(st.nextToken());
		
		long q = Long.parseLong(br.readLine());
		for(long i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			long condition = Long.parseLong(st.nextToken());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			long result = 0;
			
			if(condition==1) { // 합
				long tmp1 = r * (2 * a + (r - 1) * d) / 2;
				long tmp2 = (l - 1) * (2 * a + (l - 2) * d) / 2;
				result = tmp1 - tmp2;
			}else if(condition==2) { // 최대공약수
				if(l==r) {
					result = a+(l-1)*d;
				}else {
					result = gcd(a, d);
				}
			}
			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static long gcd(long a, long d) {
		while(d!=0) {
			long temp = a%d;
			a = d;
			d = temp;
		}
		return a;
	}
}