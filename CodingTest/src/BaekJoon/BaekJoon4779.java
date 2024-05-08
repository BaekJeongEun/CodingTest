package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon4779 {
	static char[] lineArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = null;
		while(st.hasMoreTokens()) {
			sb = new StringBuilder();
			int N = Integer.parseInt(st.nextToken());
			int len = (int) Math.pow(3, N);
			lineArr = new char[len]; //3의 N승 만큼의 크기를 가진 배열
            Arrays.fill(lineArr, '-');
			recur(0,len);
			for(int i = 0; i < lineArr.length; i++){
                sb.append(lineArr[i]);
            }
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
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
