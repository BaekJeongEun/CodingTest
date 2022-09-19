package BaekJoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1292 { // 쉽게 푸는 문제 (B1)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000];
		int cnt = 0, sum=0;
		for(int i =0; i<1000; i++) {
			for(int j=0; j<i; j++) {
				if(cnt==1000) break;
				arr[cnt] = i;
				cnt++;
			}
		}
		
		for(int i=A-1; i<B; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
