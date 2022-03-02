package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy2001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		int N, M, max=0;
		String arr[][];
		
		for(int i=0; i<TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new String[N][N];
			
			for(int j=0; j<N; j++) {
				arr[j] = br.readLine().split(" ");
			}
			max=0;
			for(int x=0; x<(N-M)+1; x++) {
				for(int y=0; y<(N-M)+1; y++) {
					int temp=0;
					for(int a=0; a<M; a++) {
						for(int b=0; b<M; b++) {
							temp += Integer.parseInt(arr[x+a][y+b]);
						}
					}
					
					if(max < temp)
						max = temp;
				}
			}
			System.out.println("#"+(i+1)+" "+max);
		}
	}

}
