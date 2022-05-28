package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BaekJoon2669 {

	static int arr[][] = new int[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int area=0;
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x_start = Integer.parseInt(st.nextToken());
			int x_end = Integer.parseInt(st.nextToken());
			int y_start = Integer.parseInt(st.nextToken());
			int y_end = Integer.parseInt(st.nextToken());
			
			for(int j=x_start; j<y_start; j++) {
				for(int k=x_end; k<y_end; k++) {
					arr[j][k] = 1;
				}
			}
		}
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]==1) {
					area++;
				}
			}
		}
		System.out.println(area);
	}

}
