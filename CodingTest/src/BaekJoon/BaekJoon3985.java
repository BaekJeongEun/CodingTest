package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon3985 {
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		arr = new int[L+1];
		int max=0, cnt=0, real_max=0, max_index=0, real_max_index=0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			max_index = (max < end-start+1)?i:max_index;
			max = (max < end-start+1)?end-start+1:max;
			
			cnt=0;
			for(int j=start; j<end+1; j++) {
				if(arr[j]==0) {
					arr[j]=i;
					cnt++;
				}
			}
			real_max_index = (real_max<cnt)?i:real_max_index;
			real_max = (real_max<cnt)?cnt:real_max;
		}
		System.out.println(max_index+"\n"+real_max_index);
	}
}