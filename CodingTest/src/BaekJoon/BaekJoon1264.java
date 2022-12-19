package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1264 { // 모음의 개수 (B4)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		while(!input.equals("#")) {
			int cnt = 0;
			for(int i=0; i<input.length(); i++) {
				if("aeiuoAEIOU".contains(input.charAt(i)+"")) {
					cnt++;
				}
			}
			sb.append(cnt+""+"\n");
			input = br.readLine();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
