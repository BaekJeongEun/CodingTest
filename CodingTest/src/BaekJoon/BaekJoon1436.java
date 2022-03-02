package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 666;
		
		while(cnt < N) {
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
			if(cnt==N)
				break;
			num++;
		}
		bw.write(String.valueOf(num));
		bw.flush();
		bw.close();
	}

}
