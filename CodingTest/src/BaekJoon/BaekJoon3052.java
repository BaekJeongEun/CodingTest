package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon3052 {
	static int arr[] = new int[42];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum=0;
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			int remain = n % 42;
			System.out.println(remain);
			if(arr[remain]==0) {
				sum++;
				arr[remain]++;
			}
		}
		bw.write(sum);
		bw.flush();
		bw.close();
	}

}
