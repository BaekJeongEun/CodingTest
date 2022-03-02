package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TC; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());// 학생 수
			int arr[] = new int[N];
			int sum=0;
			for(int j=0; j<N; j++) {	
				arr[j] = Integer.parseInt(st.nextToken());	// 점수
				sum += arr[j];	// 점수 총합
			}
			double avg = sum/N, cnt=0;
			for(int k=0; k<N; k++) {
				if(avg < arr[k])
					cnt++;
			}
			System.out.printf("%.3f%%\n", (cnt/N)*100);
		}
	}

}
