package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon4779 { // 칸토어 집합(S3)
	static char[] lineArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		String input = null;
		while((input = br.readLine()) !=null) {
			sb = new StringBuilder();
			int N = Integer.parseInt(input);
			int len = (int) Math.pow(3, N);
			lineArr = new char[len];
            Arrays.fill(lineArr, '-');
			recur(0,len);
			for(int i = 0; i < lineArr.length; i++){
                sb.append(lineArr[i]);
            }
			System.out.println(sb);
		}
	}

	private static void recur(int start, int len) {
		if(len <= 1) {
			return;
		}
		int nowlen = len/3;
		for(int i=start+nowlen; i<start+nowlen*2; i++) {
			lineArr[i] = ' ';
		}
		recur(start, nowlen);
		recur(start+nowlen*2, nowlen);
	}

}
