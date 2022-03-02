package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1051 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		
		int M = Integer.parseInt(st.nextToken());
		
		String arr[][] = new String[N][M];
		
		for(int i=0; i<N; i++) {
			String str[] = br.readLine().split("");
			arr[i] = str;
		}
		int max = 1;
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-1; j++) {
				for(int k=j+1; k<M; k++) {
					if((i+(k-j))<N && (j+(k-j))<M && arr[i][j].equals(arr[i][k]) && arr[i][j].equals(arr[i+(k-j)][j]) && arr[i][j].equals(arr[i+(k-j)][j+(k-j)])) {
						if(max < (k-j+1)*(k-j+1))
							max = (k-j+1)*(k-j+1);
					}
				}
			}
		}
		System.out.println(max);
	}

}
