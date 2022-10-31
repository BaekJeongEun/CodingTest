package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon15651 { // N과 M(3) (S3)
	static int N, M, arr[], select[];
	static StringBuilder sb;
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		select = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		list = new ArrayList<>();
		comb(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void comb(int cnt) {
		if(cnt == M) {
			for(int i=0; i<select.length; i++) {
				sb.append(select[i]+" ");
			}sb.append("\n");
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			select[cnt] = arr[i];
			comb(cnt+1);
		}
	}
}