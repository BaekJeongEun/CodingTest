package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분산처리
public class BaekJoon1009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		int a, b, sum=1;
		
		for(int i=0; i<TC; i++) {
			sum=1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<b; j++) {
				sum *= a;
				if(sum > 10)
					sum%=10;
			}
			if(sum == 0)
				sum=10;
			System.out.println(sum);
		}
	}
}
