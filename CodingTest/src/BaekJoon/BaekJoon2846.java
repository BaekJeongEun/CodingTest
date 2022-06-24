package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2846 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int load[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int load_idx = 0;
		int start = 0;
		for(int i=0; i<N-1;i++) {
			if(arr[i]<arr[i+1]) {
				load[load_idx] = arr[i+1]-arr[start];
			}
			else if(arr[i]>arr[i+1] || arr[i]==arr[i+1]) {
				load_idx++;
				start = i+1;
			}
		}
		int answer=0;
		for(int i=0; i<load.length; i++) {
			answer = Math.max(answer, load[i]);
		}
		System.out.println(answer);
	}

}
