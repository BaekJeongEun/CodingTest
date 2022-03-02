package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWExpertAcademy2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		String arr[][];
		
		for(int tc=0; tc<TC; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			arr=new String[N][N];
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine().split("");
			}
			int sum=0, start=N/2, repeat=1;
			for(int i=0; i<N; i++) {
				for(int j=start; j<start+repeat; j++) {
					sum += Integer.parseInt(arr[i][j]);
				}
				if(i < N/2) {
					start--;
					repeat+=2;
				}else {
					start++;
					repeat-=2;
				}
			}
			System.out.println("#"+(tc+1)+" "+sum);
		}

	}

}
