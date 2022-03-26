package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), result=0;
		
		for(int i=0; i<N; i++) {
			int number = i;
			int sum = 0;
			while(number!=0) {
				sum += number%10;
				number /= 10;
			}
			if(sum+i==N) {
				result = i;
				break;
			}
			
		}System.out.println(result);
	}

}
