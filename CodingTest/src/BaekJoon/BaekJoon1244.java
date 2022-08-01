package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1244 {
	static int N, student;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		student = Integer.parseInt(br.readLine());
		for(int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			if(gender == 1) { // 남학생
				male(index);
			}else { // 여학생
				female(index);
			}
		}
		
		int j = 1;
		StringBuilder sb = new StringBuilder();
		while(j<=N) {
			sb.append(arr[j]+" ");
			if(j % 20 == 0) {
				sb.append("\n");
			}
			j++;
		}
		
		System.out.println(sb.toString());
	}
	private static void male(int index) {
		int mul = 2;
		for(int i=index; i<=N; i = index*mul++) {		
			if(arr[i] == 1)
				arr[i] = 0;
			else arr[i] = 1;
		}
	}
	private static void female(int index) {
		if(arr[index] == 1)
			arr[index] = 0;
		else arr[index] = 1;
		for(int i=index-1, j=index+1; i>=1 && j<=N; i--, j++) {
			if(arr[i] == arr[j]) {
				if(arr[i] == 1) {
					arr[i] = 0;
					arr[j] = 0;
				}
				else {
					arr[i] = 1;
					arr[j] = 1;
				}
			}else break;
		}
	}

}
