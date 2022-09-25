package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon24956 { // 나는 정말 휘파람을 못 불어 (G4)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int[] sum = new int[4]; // WHE
		for(int i=0; i<N; i++) {
			if(arr[i] == 'W') {
				sum[0]++;
			}else if(arr[i] == 'H') {
				sum[1] += sum[0];
				if(sum[1] > 1000000006) sum[1] -= 1000000007;
			}else if(arr[i] == 'E') {
				sum[3] += sum[3] + sum[2];
				while (sum[3] > 1000000006) sum[3] -= 1000000007;
				sum[2] += sum[1];
				if (sum[2] > 1000000006) sum[2] -= 1000000007;
			}
		}
		System.out.println(sum[3]);
	}

}
