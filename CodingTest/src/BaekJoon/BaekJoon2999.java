package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2999 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String message = br.readLine();
		int index=0;
		String arr[][];
		StringBuilder sb = new StringBuilder();
		
		int N=message.length(),R=0,C=0;
		
		for(int i=1; i<=N; i++) {
			if(N%i==0 && i<=N/i && R<i) {
				R=i;
				C=N/R;
			}
		}
		arr = new String[R][C];
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				arr[j][i] = String.valueOf(message.charAt(index));
				index++;
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(arr[i][j].toString());
			}
		}
		System.out.println(sb);
	}

}
