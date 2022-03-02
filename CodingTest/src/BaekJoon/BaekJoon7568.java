package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		int rank[] = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			rank[i] = 1;
		}
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N-1; j++) {
				System.out.println(arr[i][0]+","+arr[j+1][0] +" / "+ arr[i][1]+","+arr[j+1][1]);
				if(arr[i][0]<arr[j+1][0] && arr[i][1]<arr[j+1][1]) {
					System.out.println("ÀÛ¾Æ");
					rank[i]++;
				}
				else if(arr[i][0]>arr[j+1][0] && arr[i][1]>arr[j+1][1]) {
					System.out.println("Ä¿");
					rank[j+1]++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			bw.write(String.valueOf(rank[i])+" ");
		}
		bw.flush();
		bw.close();
	}

}
