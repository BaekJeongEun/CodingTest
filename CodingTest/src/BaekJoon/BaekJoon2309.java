package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BaekJoon2309 { // 일곱 난쟁이 (B1)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[9];
		boolean exit = false;
		int sum = 0, a=0, b=0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		for(int i=0; i<9 && !exit; i++) {
			for(int j=0; j<9; j++) {
				if(i!=j) {
					if(sum - arr[i] - arr[j] == 100) {
						a = arr[i]; b = arr[j];
						exit = true;
						break;
					}
				}
			}
		}
		for(int i=0; i<9; i++) {
			if(arr[i]!=a && arr[i]!=b) {
				sb.append(arr[i]).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
