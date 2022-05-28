package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
		int a[] = new int[3];
		int pass=0, sum=0;
		for(int i=0; i<N; i++) {
			boolean exit = false;
			sum=0;
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int score = Integer.parseInt(st.nextToken());
				a[j]=score;
				if(score<M) {
					exit=true;
					break;
				}
				sum += score;
			}
			if(exit || sum<S) continue; // 개인 점수 미달이거나 전체 합 미달
			for(int k=0; k<3; k++) {
				arr.add(a[k]);
			}
			pass++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pass+"\n");
		for(Integer aa : arr) {
			sb.append(aa+" ");
		}
		System.out.println(sb.toString());
	}

}
