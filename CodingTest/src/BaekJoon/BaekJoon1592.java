package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1592 {
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		int cnt = 0;
		int index = 1; 
		
		while(true) {
			arr[index]++;
			if(arr[index]==M) {
				break;
			}
			cnt++;
			if(arr[index]%2!=0) {
				index = ((index+L)>=N+1)?(index+L)%N:index+L;
			}
			else {
				index = ((index-L)<1)?(index+N-L):index-L;
			}
		}
		System.out.println(cnt);
	}

}
